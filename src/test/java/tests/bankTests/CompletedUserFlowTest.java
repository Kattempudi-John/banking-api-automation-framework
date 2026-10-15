package tests.bankTests;


import api.CreateAccountApi;
import data.UserAccountDataProvider;
import io.restassured.response.Response;
import models.*;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import utilities.KycDeatilsTestDataGenarator;

@Listeners(listeners.TestListener.class)
public class CompletedUserFlowTest {

    @Test(
            dataProvider = "createAccount",
            dataProviderClass = UserAccountDataProvider.class
    )
    public void verifyCompleteUserFlow(CreateAccountTestData testData) {
        CreateAccountApi api = new CreateAccountApi();

        // FIX 1: Use the Request payload provided by the DataProvider scenario!
        CreateAccountRequest accountRequest = testData.getRequest();

        // STEP 1: Create account using the scenario-driven test data
        Response registerResponse = api.addUser(accountRequest);

        Assert.assertEquals(
                registerResponse.getStatusCode(),
                testData.getExpectedStatus(),
                "Account creation status mismatch for scenario: " + testData.getScenarioName()
        );

        CreateAccountResponse accountResponse = registerResponse.as(CreateAccountResponse.class);

        if (testData.getBusinessStatus() != null) {
            Assert.assertEquals(
                    accountResponse.getStatus(),
                    testData.getBusinessStatus(),
                    "Account creation business status mismatch"
            );
        }

        // FIX 2: Gracefully exit if the account registration was expected to fail (e.g., Invalid Email)
        if (registerResponse.getStatusCode() < 200 || registerResponse.getStatusCode() >= 300) {
            System.out.println("Stopping flow: Registration failed as expected for scenario: " + testData.getScenarioName());
            return;
        }

        // STEP 2: Reuse the same username and password for subsequent flow (Happy Path only)
        LoginRequest loginRequest = new LoginRequest(
                accountRequest.getUsername(),
                accountRequest.getPassword()
        );

        Response loginRaw = api.login(loginRequest);
        Assert.assertEquals(loginRaw.getStatusCode(), 202, "Login failed");

        LoginResponse loginResponse = loginRaw.as(LoginResponse.class);
        Assert.assertEquals(loginResponse.getStatus(), "2FA_REQUIRED");

        String preAuthToken = loginResponse.getPreAuthToken();
        Assert.assertNotNull(preAuthToken);
        Assert.assertFalse(preAuthToken.isEmpty());

        // STEP 3: Retrieve OTP for the newly created account
        Response otpRaw = api.getOtp(accountRequest.getUsername());
        Assert.assertTrue(
                otpRaw.getStatusCode() >= 200 && otpRaw.getStatusCode() < 300,
                "OTP retrieval failed"
        );

        GetOtpResponse otpResponse = otpRaw.as(GetOtpResponse.class);
        Assert.assertNotNull(otpResponse.getOtp(), "OTP is missing");

        // STEP 4: Verify OTP using pre-auth token
        LoginOtpRequest otpRequest = new LoginOtpRequest(otpResponse.getOtp());
        Response verifyRaw = api.verifyOtp(otpRequest, preAuthToken);
        Assert.assertTrue(
                verifyRaw.getStatusCode() >= 200 && verifyRaw.getStatusCode() < 300,
                "OTP verification failed"
        );

        LoginOtpResponse verifyResponse = verifyRaw.as(LoginOtpResponse.class);
        Assert.assertEquals(verifyResponse.getStatus(), "SUCCESS");

        String accessToken = verifyResponse.getAccessToken();
        Assert.assertNotNull(accessToken, "Access token is missing");
        Assert.assertFalse(accessToken.isEmpty());

        // STEP 5: Generate random KYC details
        UserKycRequest kycRequest = KycDeatilsTestDataGenarator.updateKycDetails();

        // STEP 6: Update KYC using the access token
        Response kycRaw = api.updateKyc(kycRequest, accessToken);
        Assert.assertTrue(
                kycRaw.getStatusCode() >= 200 && kycRaw.getStatusCode() < 300,
                "KYC update failed"
        );

        UserKycResponse kycResponse = kycRaw.as(UserKycResponse.class);
        Assert.assertNotNull(kycResponse.getMessage(), "KYC response message is missing");
    }

}
