package models;

import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
public class LoginResponse {

    private String pre_auth_token;

    private int expires_in_seconds;

    private String status;
}
