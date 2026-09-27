package tests;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import models.UserRequest;

public class SerializationTest {

    public static void main(String[] args) throws JsonProcessingException {

        UserRequest request = new UserRequest(
                "john",
                "Software"
        );

        ObjectMapper mapper = new ObjectMapper();

        String json = mapper.writeValueAsString(request);

        System.out.println(json);
    }
}
