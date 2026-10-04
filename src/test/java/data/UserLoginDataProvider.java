package data;

import org.testng.annotations.DataProvider;
import utilities.LoginTestDataGenarator;

public class UserLoginDataProvider {

    @DataProvider(name = "loginDetails")
    public Object[][] login(){

        return new Object[][]{
                {LoginTestDataGenarator.validLogin()}
        };
    }
}
