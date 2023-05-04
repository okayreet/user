package com.catalogue.user.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class UserDto {
    private String firstName;
    private String lastName;
    private String address1;
    private String address2;
    private String city;
    private String postcode;
    private String phoneNumber;
    private String email;
    private String role;
}
