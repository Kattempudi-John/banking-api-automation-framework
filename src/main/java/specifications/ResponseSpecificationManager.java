package specifications;

import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.specification.ResponseSpecification;


import static io.restassured.http.ContentType.JSON;

public class ResponseSpecificationManager {

    public static ResponseSpecification getSuccessResponse() {

        return new ResponseSpecBuilder()
                .expectStatusCode(200)
                .expectContentType(JSON)
                .build();
    }

    public static ResponseSpecification createSuccessResponse() {

        return new ResponseSpecBuilder()
                .expectStatusCode(201)
                .expectContentType(JSON)
                .build();
    }

    public static ResponseSpecification deleteSuccessResponse() {

        return new ResponseSpecBuilder()
                .expectStatusCode(204)
                .build();
    }
}
