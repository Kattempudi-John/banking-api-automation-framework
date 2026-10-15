package tests.bankTests;

import api.CreateAccountApi;
import data.UserAccountDataProvider;
import data.UserLoginDataProvider;
import io.restassured.response.Response;
import models.LoginRequest;
import models.LoginResponse;
import org.testng.Assert;
import org.testng.annotations.Test;


public class LoginTest {

    @Test(
            dataProvider = "loginDetails",
            dataProviderClass = UserLoginDataProvider.class
    )
    public void verifyLogin(LoginRequest request){

        CreateAccountApi api = new CreateAccountApi();

        Response response = api.login(request);

        Assert.assertEquals(202, response.getStatusCode());

        LoginResponse loginResponse =
                response.as(LoginResponse.class);

        Assert.assertEquals("2FA_REQUIRED", loginResponse.getStatus());

        Assert.assertEquals(180, loginResponse.getExpiresInSeconds());

        String token = loginResponse.getPreAuthToken();

        Assert.assertNotNull(token, "Pre-auth token should not be null");
        Assert.assertFalse(token.isEmpty(), "Pre-auth token should not be empty");
    }
}
