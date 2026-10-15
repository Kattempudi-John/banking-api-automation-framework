package api;

import clients.ApiClient;
import endpoints.UserEndpoints;
import io.restassured.response.Response;
import models.UserRequest;

public class UserApi {

    private final ApiClient apiClient;

    public UserApi() {
        this.apiClient = new ApiClient();
    }

    // GET user by ID using a path parameter
    public Response getUserById(int id) {
        return apiClient.getByQueryParam(
                UserEndpoints.USER_BY_ID,
                "id",
                id
        );
    }

    // POST request to create a user
    public Response addUser(UserRequest request) {
        return apiClient.post(
                UserEndpoints.USERS,
                request
        );
    }
}
