package com.catalogue.user.dto;

public record UserDto(
                String firstName,
                String lastName,
                String address1,
                String address2,
                String city,
                String postcode,
                String phoneNumber) {
}
