package models;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDate;

@AllArgsConstructor
@Getter
public class UserKycRequest {

    private String legalName;

    @com.fasterxml.jackson.annotation.JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate dateOfBirth;

    private String phoneNumber;

    private String addressLine1;

    private String addressLine2;

    private String city;

    private String state;

    private String zipCode;

}
