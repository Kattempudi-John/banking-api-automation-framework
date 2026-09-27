package utilities;

import com.github.javafaker.Faker;
import models.UserRequest;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class TestDataGenarator {

    private static final Faker faker = new Faker();
    private static final Random random = new Random();


    public static String genarateName(){

        return faker.name().fullName();
    }

    public static String generateJobs(){

        String[] skills = {"Java Developer", "Python Developer", "Testing"};

        int index = ThreadLocalRandom.current().nextInt(skills.length);

        return skills[index];
    }

    public static UserRequest userDetails(){

        String name = genarateName();
        String job = generateJobs();

        return new UserRequest(
                name,
                job
        );
    }




}
