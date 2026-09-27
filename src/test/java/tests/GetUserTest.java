package tests;

import api.UserApi;
import io.restassured.response.Response;
import listeners.TestListener;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import static org.hamcrest.Matchers.*;

@Listeners(TestListener.class)
public class GetUserTest {

    @Test
    public void verifyGetUserDetails(){

        UserApi userApi = new UserApi();

        Response response = userApi.getUserById(2);

        response.then()
                .statusCode(200)
                .body("data.id", equalTo(2));

    }
}
