package models;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
public class LoginResponse {

    private String status;

    @JsonProperty("pre_auth_token")
    private String preAuthToken;

    @JsonProperty("expires_in_seconds")
    private int expiresInSeconds;
}
