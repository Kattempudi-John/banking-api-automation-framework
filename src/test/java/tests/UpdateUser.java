package tests;

import io.restassured.response.Response;
import models.UserRequest;
import org.testng.annotations.Test;
import services.UserService;
import specifications.ResponseSpecificationManager;

public class UpdateUser {

    @Test
    public void UpdateUserDetails(){

        UserRequest request = new UserRequest(
                "Chandu", "Developer"
        );

        UserService userService = new UserService();

        Response response = userService.updateUser(1, request);

        response.then()
                .spec(ResponseSpecificationManager.getSuccessResponse());

    }
}
