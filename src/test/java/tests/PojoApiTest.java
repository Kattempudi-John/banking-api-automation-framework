package tests;

import io.restassured.http.ContentType;
import models.UserRequest;
import models.UserResponse;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.notNullValue;


public class PojoApiTest {

    String baseURI = "https://reqres.in";

    @Test
    public void createUserUisngPojo() {

        UserRequest request = new UserRequest(
                "Suresh", "QA Engineer"
        );

        given()
            .baseUri(baseURI)
            .contentType(ContentType.JSON)
            .body(request)

        .when()
            .post("api/users")

        .then()
            .statusCode(201)
            .body("name", equalTo("Suresh"))
            .body("job", equalTo("QA Engineer"))
            .body("id", notNullValue())
            .extract()
            .as(UserResponse.class);
    }


}
