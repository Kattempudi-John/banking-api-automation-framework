package clients;

import config.ConfigReader;
import io.restassured.response.Response;
import specifications.RequestSpecificationManager;
import utilities.ApiLogger;

import static io.restassured.RestAssured.given;

public class ApiClient {

    public Response get(
            String endpoint,
            String paramName,
            Object paramValue) {

        String requestUri =
                ConfigReader.get("base.url")
                        + ConfigReader.get("base.path")
                        + endpoint.replace(
                        "{" + paramName + "}",
                        String.valueOf(paramValue)
                );

        ApiLogger.logRequest(
                "GET",
                requestUri
        );

        Response response = given()
                .spec(RequestSpecificationManager.getRequestSpecification())
                .pathParam(paramName, paramValue)

        .when()
                .get(endpoint)

        .then()
                .extract()
                .response();

        ApiLogger.logResponse(response);

        return response;
    }

    public Response post(String endpoint, Object requestBody){

        return given()
                .spec(RequestSpecificationManager.getRequestSpecification())
                .body(requestBody)
        .when()
                .post(endpoint);

    }
}
