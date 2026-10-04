package api;

import clients.ApiClient;
import endpoints.AuthEndPoints;
import io.restassured.response.Response;
import models.CreateAccountRequest;
import models.LoginRequest;


public class CreateAccountApi {

    private final ApiClient apiClient;

    public CreateAccountApi(){
        apiClient = new ApiClient();
    }

    public Response addUser(CreateAccountRequest request){

        return apiClient.post(
                AuthEndPoints.Register,
                request
        );
    }

    public Response login(LoginRequest request){
        return apiClient.post(
                AuthEndPoints.Login,
                request
        );
    }
}
