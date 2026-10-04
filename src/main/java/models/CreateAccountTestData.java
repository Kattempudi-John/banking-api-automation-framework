package models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@AllArgsConstructor
@Getter
@Builder(toBuilder = true)
public class CreateAccountTestData {

    private String scenarioName;

    private CreateAccountRequest request;

    private int expectedStatus;

    private String businessStatus;

    private String expectedMessage;

    private String expectedError;

}
