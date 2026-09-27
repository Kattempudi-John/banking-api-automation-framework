package api;

import clients.ApiClient;
import endpoints.UserEndpoints;
import io.restassured.response.Response;
import models.UserRequest;

public class UserApi {

    private final ApiClient apiClient;

    public UserApi(){

        apiClient = new ApiClient();
    }

    public Response getUserById(int id){

        return apiClient.get(
                UserEndpoints.USER_BY_ID,
                "id",
                id
        );
    }

    public Response addUser(UserRequest request){

        return apiClient.post(
                UserEndpoints.USERS,
                request
        );
    }

}
