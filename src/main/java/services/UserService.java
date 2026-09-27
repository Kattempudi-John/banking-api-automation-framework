package services;

import io.restassured.response.Response;
import models.UserRequest;
import specifications.RequestSpecificationManager;

import java.util.Map;

import static io.restassured.RestAssured.given;

public class UserService {

    public Response getUserById(int id){

        return given()
                .spec(RequestSpecificationManager.getRequestSpecification())
                .pathParam("id", id)

        .when()
                .get("/users/{id}");
    }

    public Response getUsers(int page){

        return given()
                .spec(RequestSpecificationManager.getRequestSpecification())
                .queryParam("page", page)

        .when()
                .get("/users");

    }

    public Response createUser(UserRequest request){

        return given()
                .spec(RequestSpecificationManager.getRequestSpecification())
                .body(request)

        .when()
                .post("/users");
    }

    public Response updateUser(int id, UserRequest request){

        return given()
                .spec(RequestSpecificationManager.getRequestSpecification())
                .pathParam("id", id)
                .body(request)

        .when()
                .put("/users/{id}");
    }

    public Response patchUser(int id, Map<String, Object> requestBody){

        return given()
                .spec(RequestSpecificationManager.getRequestSpecification())
                .pathParam("id", id)
                .body(requestBody)

                .when()
                .patch("/users/{id}");
    }

    public Response deleteUser(int id){

        return given()
                .spec(RequestSpecificationManager.getRequestSpecification())
                .pathParam("id", id)

        .when()
                .delete("/users/{id}");
    }
}
