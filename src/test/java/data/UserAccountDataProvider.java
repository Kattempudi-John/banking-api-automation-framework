package data;

import models.CreateAccountRequest;
import models.CreateAccountTestData;
import org.testng.annotations.DataProvider;
import utilities.CreateAccountTestDataGenerator;

public class UserAccountDataProvider {


    // Regression: positive and negative scenarios
    @DataProvider(name = "createAccount")
    public static Object[][] accountDetails() {

        CreateAccountRequest validRequest =
                CreateAccountTestDataGenerator.createAccount();

        CreateAccountRequest invalidRequest =
                CreateAccountTestDataGenerator
                        .createAccountWithInvalidEmail();

        return new Object[][]{
                {
                        new CreateAccountTestData(
                                "Valid Account Creation",
                                validRequest,
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
                }
        };
    }

    // Smoke: only valid account creation
    @DataProvider(name = "validAccount")
    public static Object[][] validAccountDetails() {

        CreateAccountRequest validRequest =
                CreateAccountTestDataGenerator.createAccount();

        return new Object[][]{
                {
                        new CreateAccountTestData(
                                "Valid Account Complete User Flow",
                                validRequest,
                                201,
                                "SUCCESS",
                                "Account created successfully",
                                null
                        )
                }
        };
    }
}
