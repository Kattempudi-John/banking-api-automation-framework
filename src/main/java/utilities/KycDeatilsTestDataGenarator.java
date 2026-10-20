package utilities;

import com.github.javafaker.Faker;
import models.UserKycRequest;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.ThreadLocalRandom;

public class KycDeatilsTestDataGenarator {

    private static final Faker faker = new Faker();


    public static String getRandomFullName() {
        return faker.name().fullName();
    }

    public static Date getRandomDateOfBirth() {
        long startMillis = 315532800000L;  // 1980-01-01
        long endMillis = 1136073600000L;   // 2006-01-01

        long randomMillis = ThreadLocalRandom.current()
                .nextLong(startMillis, endMillis);

        return new Date(randomMillis);
    }

    public static String getRandomPhoneNumber() {
        return String.valueOf(
                ThreadLocalRandom.current()
                        .nextLong(6000000000L, 10000000000L)
        );
    }

    public static String getRandomAddress() {
        return faker.address().streetAddress();
    }

    public static String getRandomLayout() {
        return faker.address().streetName();
    }

    public static String getRandomCity() {
        return faker.address().city();
    }

    public static String getRandomState() {
        return faker.address().state();
    }

    public static String getRandomPinCode() {
        return String.valueOf(
                ThreadLocalRandom.current()
                        .nextInt(100000, 1000000)
        );
    }

    public static String formatDate(Date date) {
        return new SimpleDateFormat("yyyy-MM-dd")
                .format(date);
    }

    public static UserKycRequest updateKycDetails(){
        String fullname = getRandomFullName();
        java.time.LocalDate date = getRandomDateOfBirth().toInstant()
                .atZone(java.time.ZoneId.systemDefault())
                .toLocalDate();
        String phonenumber = getRandomPhoneNumber();
        String address = getRandomAddress();
        String streetName = getRandomLayout();
        String city = getRandomCity();
        String state = getRandomState();
        String pincode = getRandomPinCode();

        return new UserKycRequest(
                fullname,
                date,
                phonenumber,
                address,
                streetName,
                city,
                state,
                pincode
        );
    }

}
