package utilities;

import models.LoginRequest;

public class LoginTestDataGenarator {


    public static LoginRequest validLogin(){

        String username = "John2217";

        String passeord = "Test2217@@";

        return new LoginRequest(
                username,
                passeord
        );
    }
}
