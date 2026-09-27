package tests;

import io.restassured.response.Response;
import org.testng.annotations.Test;
import services.UserService;
import specifications.ResponseSpecificationManager;

public class DeleteUser {


    @Test
    public void deleteUser(){

        UserService userService = new UserService();

        Response response = userService.deleteUser(1);

        response.then()
                .spec(ResponseSpecificationManager.deleteSuccessResponse());
    }
}
