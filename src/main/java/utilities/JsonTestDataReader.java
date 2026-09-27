package utilities;

import com.fasterxml.jackson.databind.ObjectMapper;
import models.UserRequest;

import java.io.InputStream;

public class JsonTestDataReader {

    public static UserRequest readUserRequest() {

        try {

            ObjectMapper mapper = new ObjectMapper();

            InputStream inputStream = JsonTestDataReader.class
                    .getClassLoader()
                    .getResourceAsStream(
                            "testdata/create-user.json"
                    );

            if (inputStream == null) {
                throw new RuntimeException(
                        "create-user.json not found"
                );
            }

            return mapper.readValue(
                    inputStream,
                    UserRequest.class
            );

        } catch (Exception e) {
            throw new RuntimeException(
                    "Failed to read create-user.json", e);
        }

    }
}
