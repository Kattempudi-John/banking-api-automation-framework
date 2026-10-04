package utilities;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.testng.Assert;

import static io.restassured.RestAssured.given;

public class RestAssuredJsonPathPractice {

    public static void main(String[] args) {

        String baseURI = "https://reqres.in";

        Response response =
                given()
                        .baseUri(baseURI)
                        .when()
                        .get("/api/users/2");

        System.out.println("Response:");
        System.out.println(response.asPrettyString());

        int id =
                response.jsonPath().getInt("data.id");

        String email =
                response.jsonPath().getString("data.email");

        String firstName =
                response.jsonPath().getString("data.first_name");

        Assert.assertEquals(firstName,"");

        Assert.assertEquals(email, "janet.weaver@reqres.in");

        Assert.assertEquals(id, 2);
        Assert.assertNotNull(email);
        Assert.assertNotNull(firstName);

        Assert.assertNotNull("id");

        System.out.println("ID: " + id);
        System.out.println("Email: " + email);
        System.out.println("First Name: " + firstName);
    }
}
