package specifications;

import config.ConfigReader;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;

import static io.restassured.http.ContentType.JSON;

public class RequestSpecificationManager {

    public static RequestSpecification getRequestSpecification() {

        return new RequestSpecBuilder()
                .setBaseUri(ConfigReader.get("base.url"))
                .setBasePath(ConfigReader.get("base.path"))
                .setContentType(JSON)
                .setAccept(JSON)
                .addHeader("X-API-Version", "v1")
                .build();
    }
}
