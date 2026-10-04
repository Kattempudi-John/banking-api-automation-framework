package utilities;

import com.github.javafaker.Faker;
import models.CreateAccountRequest;

public class CreateAccountTestDataGenerator {

    private static final Faker faker = new Faker();

    public static String generateUserName(){

        return faker.name().username();
    }

    public static String userPassword(){

        return "Hsr@1234";
    }

    public static String generatePhoneNumber(){

        String phoneNUmber =
                faker.options().option("6","7", "8", "9")
                + faker.number().digits(9);

        return phoneNUmber;
    }

    public static String generateEmail(){

        return generateUserName() + "@gmail.com";
    }

    public static CreateAccountRequest createAccount(){

        String username = generateUserName();
        String password = userPassword();
        String phoneNumber = generatePhoneNumber();
        String email = generateEmail();

        return new CreateAccountRequest(
                username,
                password,
                phoneNumber,
                email
        );
    }

    public static CreateAccountRequest createAccountWithInvalidEmail(){

        CreateAccountRequest validAccount = createAccount();

        return validAccount
                .toBuilder()
                .email("john")
                .build();
    }
}
