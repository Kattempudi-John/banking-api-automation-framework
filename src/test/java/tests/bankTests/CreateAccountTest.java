package tests.bankTests;

import api.CreateAccountApi;
import data.UserAccountDataProvider;
import io.restassured.response.Response;
import models.CreateAccountResponse;
import models.CreateAccountTestData;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CreateAccountTest {

    @Test(
            dataProvider = "createAccount",
            dataProviderClass = UserAccountDataProvider.class
    )
    public void verifyAccountCreation(CreateAccountTestData testData){

        CreateAccountApi createAccountApi = new CreateAccountApi();

        Response response = createAccountApi.addUser(testData.getRequest());

//        response.then()
//                .spec(ResponseSpecificationManager.createSuccessResponse());

        Assert.assertEquals(
                response.getStatusCode(),
                testData.getExpectedStatus(),
                "Status code mismatch for: " + testData.getScenarioName());

        Assert.assertEquals(
                response.getStatusCode(),
                testData.getExpectedStatus(),
                "Status code mismatch for: " + testData.getScenarioName());

        CreateAccountResponse accountResponse =
                response.as(CreateAccountResponse.class);

        if(testData.getBusinessStatus() != null){

            Assert.assertEquals(
                    accountResponse.getStatus(),
                    testData.getBusinessStatus(),
                    "Business status mismatch for: " + testData.getScenarioName()
            );
        }

        if(testData.getExpectedMessage() != null){

            Assert.assertEquals(
                    accountResponse.getMessage(),
                    testData.getExpectedMessage(),
            "Message mismatch for: " + testData.getScenarioName()
            );
        }

        if(testData.getExpectedError() != null){

            Assert.assertEquals(
                    accountResponse.getStatus(),
                    testData.getBusinessStatus(),
                    "Business status mismatch for: " + testData.getScenarioName()
            );
        }

    }
}
