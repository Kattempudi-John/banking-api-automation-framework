package tests;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

public class NegativeTest {

    @Test
    public void verifyGetInvalidUser(){

        given()
            .baseUri("https://reqres.in")
            .pathParams("id",15)

        .when()
            .get("/api/users/{id}")

        .then()
            .statusCode(404);
    }
}
