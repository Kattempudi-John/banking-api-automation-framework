package models;

import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter

public class CreateAccountResponse {

    private String status;

    private String message;

    private String error;

}
