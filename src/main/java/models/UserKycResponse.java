package models;

import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
public class UserKycResponse {

    private String kycStatus;

    private String message;
}
