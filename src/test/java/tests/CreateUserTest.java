package tests;


import api.UserApi;
import io.restassured.response.Response;
import models.UserRequest;
import models.UserResponse;
import org.testng.Assert;
import org.testng.annotations.Test;
import specifications.ResponseSpecificationManager;
import utilities.TestDataGenarator;


public class CreateUserTest {

    @Test
    public void verifyCreateUser(){

        UserRequest request = TestDataGenarator.userDetails();

        UserApi userApi = new UserApi();

        Response response = userApi.addUser(request);

        response.then()
                .spec(ResponseSpecificationManager.createSuccessResponse());

        UserResponse userResponse =
                response.as(UserResponse.class);

        Assert.assertEquals(userResponse.getName(),request.getName());
        Assert.assertEquals(userResponse.getJob(),request.getJob());

    }
}
