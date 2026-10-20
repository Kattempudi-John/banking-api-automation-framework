package clients;

import config.ConfigReader;
import io.restassured.response.Response;
import specifications.RequestSpecificationManager;
import utilities.ApiLogger;

import static io.restassured.RestAssured.given;

public class ApiClient {

    public Response getByQueryParam(
            String endpoint,
            String paramName,
            Object paramValue) {

        Response response = given()
                .spec(RequestSpecificationManager.getRequestSpecification())
                .queryParam(paramName, paramValue)
                .log().all()
                .when()
                .get(endpoint)
                .then()
                .extract()
                .response();

        ApiLogger.logResponse(response);
        return response;
    }

    public Response post(String endpoint, Object requestBody) {

        Response response = given()
                .spec(RequestSpecificationManager.getRequestSpecification())
                .body(requestBody)
                .log().all()
                .when()
                .post(endpoint)
                .then()
                .extract()
                .response();

        ApiLogger.logResponse(response);
        return response;
    }

    public Response postWithToken(
            String endpoint,
            Object requestBody,
            String accessToken) {

        Response response = given()
                .spec(RequestSpecificationManager.getRequestSpecification())
                .header("Authorization", "Bearer " + accessToken)
                .body(requestBody)
                .log().all()
                .when()
                .post(endpoint)
                .then()
                .extract()
                .response();

        ApiLogger.logResponse(response);
        return response;
    }

    public Response putWithToken(
            String endpoint,
            Object requestBody,
            String accessToken) {

        Response response = given()
                .spec(RequestSpecificationManager.getRequestSpecification(
                        ConfigReader.get("profile.base.url")))
                .header("Authorization", "Bearer " + accessToken)
                .body(requestBody)
                .log().all()
                .when()
                .put(endpoint)
                .then()
                .extract()
                .response();

        ApiLogger.logResponse(response);
        return response;
    }
}
