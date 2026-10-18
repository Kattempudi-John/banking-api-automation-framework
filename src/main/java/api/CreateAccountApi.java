package api;

import clients.ApiClient;
import endpoints.AuthEndPoints;
import io.restassured.response.Response;
import models.CreateAccountRequest;
import models.LoginOtpRequest;
import models.LoginRequest;
import models.UserKycRequest;


public class CreateAccountApi {

    private final ApiClient apiClient;

    public CreateAccountApi() {
        this.apiClient = new ApiClient();
    }

    // Register a new user
    public Response addUser(CreateAccountRequest request) {
        return apiClient.post(
                AuthEndPoints.Register,
                request
        );
    }

    // Login and receive pre_auth_token
    public Response login(LoginRequest request) {
        return apiClient.post(
                AuthEndPoints.Login,
                request
        );
    }

    // Retrieve OTP using username
    public Response getOtp(String username) {
        return apiClient.getByQueryParam(
                AuthEndPoints.GetOTP,
                "username",
                username
        );
    }

    // Verify OTP using pre_auth_token
    public Response verifyOtp(
            LoginOtpRequest request,
            String preAuthToken) {

        return apiClient.postWithToken(
                AuthEndPoints.VerifyOTP,
                request,
                preAuthToken
        );
    }

    // Update KYC using access_token
    public Response updateKyc(
            UserKycRequest request,
            String accessToken) {

        return apiClient.putWithToken(
                AuthEndPoints.Kyc,
                request,
                accessToken
        );
    }

}
