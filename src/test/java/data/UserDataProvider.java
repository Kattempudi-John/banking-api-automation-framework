package data;

import org.testng.annotations.DataProvider;
import utilities.TestDataGenarator;

public class UserDataProvider {

    @DataProvider(name = "userData")
    public Object[][] userData(){

        return new Object[][]{
                {TestDataGenarator.userDetails()}
        };
    }
}
