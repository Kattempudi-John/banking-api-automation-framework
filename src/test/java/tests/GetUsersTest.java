package tests;

import io.restassured.response.Response;
import org.testng.annotations.Test;
import services.UserService;

import static org.hamcrest.Matchers.equalTo;

public class GetUsersTest {

    @Test
    public void verifyGetUsers(){

        UserService userService = new UserService();

        Response response = userService.getUsers(2);

        response.then()
                .statusCode(200)
                .body("page", equalTo(2))
                .log().all();
    }
}
