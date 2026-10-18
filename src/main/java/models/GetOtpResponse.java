package models;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class GetOtpResponse {

    private String otp;

    private String status;

    private String username;
}
