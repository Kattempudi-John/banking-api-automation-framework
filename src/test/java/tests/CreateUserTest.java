package tests;


import api.UserApi;
import data.UserDataProvider;
import io.restassured.response.Response;
import models.UserRequest;
import models.UserResponse;
import org.testng.Assert;
import org.testng.annotations.Test;
import specifications.ResponseSpecificationManager;


public class CreateUserTest {

    @Test(
            dataProvider = "userData",
            dataProviderClass = UserDataProvider.class
    )
    public void verifyCreateUser(UserRequest request){

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
