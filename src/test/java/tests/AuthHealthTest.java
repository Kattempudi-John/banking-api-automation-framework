package tests;

import io.restassured.RestAssured;
import org.testng.annotations.Test;

import static org.hamcrest.Matchers.*;

public class AuthHealthTest {

    @Test
    public void verifyAuthServiceIsReachable() {

        RestAssured
                .given()
                .when()
                .get("http://localhost:8081/actuator/health")
                .then()
                .statusCode(anyOf(is(200), is(401), is(403)));
    }
}
