package models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@AllArgsConstructor
@Getter
@Builder(toBuilder = true)
public class CreateAccountRequest {

    private String username;

    private String password;

    private String phoneNumber;

    private String email;


}
