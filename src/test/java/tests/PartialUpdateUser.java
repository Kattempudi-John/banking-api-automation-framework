package tests;

import io.restassured.response.Response;
import org.testng.annotations.Test;
import services.UserService;
import specifications.ResponseSpecificationManager;

import java.util.HashMap;
import java.util.Map;

import static org.hamcrest.Matchers.equalTo;

public class PartialUpdateUser {

    @Test
    public void verifyPatchUser(){

        Map<String, Object> requestBody = new HashMap<>();

        requestBody.put("job","Senior QA Engineer");

        UserService userService = new UserService();

        Response response = userService.patchUser(2, requestBody);

        response.then()
                .spec(ResponseSpecificationManager.getSuccessResponse())
                .body("job", equalTo("Senior QA Engineer"));
    }
}
