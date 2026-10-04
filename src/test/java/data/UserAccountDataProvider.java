package data;

import models.CreateAccountRequest;
import models.CreateAccountTestData;
import org.testng.annotations.DataProvider;
import utilities.CreateAccountTestDataGenerator;

public class UserAccountDataProvider {

    @DataProvider(name = "createAccount")
    public Object[][] accountDetails(){

        CreateAccountRequest request =
                CreateAccountTestDataGenerator.createAccount();

        CreateAccountRequest invalidRequest =
                CreateAccountTestDataGenerator.createAccountWithInvalidEmail();

        return new Object[][]{
                {
                    new CreateAccountTestData(
                            "Valid Account Creation",
                            request,
                            201,
                            "SUCCESS",
                            "Account created successfully",
                            null
                    )
                },
                {
                        new CreateAccountTestData(
                                "Invalid Email",
                                invalidRequest,
                                400,
                                null,
                                null,
                                "Please enter a valid email address"

                        )
                },


        };
    }
}
