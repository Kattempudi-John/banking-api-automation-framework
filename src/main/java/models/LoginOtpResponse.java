package models;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
public class LoginOtpResponse {

    private String status;

    @JsonProperty("access_token")
    private String accessToken;
}
