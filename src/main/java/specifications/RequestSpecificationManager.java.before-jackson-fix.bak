package specifications;

import config.ConfigReader;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;

import static io.restassured.http.ContentType.JSON;

public class RequestSpecificationManager {

    public static RequestSpecification getRequestSpecification() {
        return getRequestSpecification(
                ConfigReader.get("auth.base.url")
        );
    }

    public static RequestSpecification getRequestSpecification(
            String baseUrl) {

        return new RequestSpecBuilder()
                .setBaseUri(baseUrl)
                .setBasePath(ConfigReader.get("api.base.path"))
                .setContentType(JSON)
                .setAccept(JSON)
                .addHeader("X-API-Version", "v1")
                .build();
    }
}
