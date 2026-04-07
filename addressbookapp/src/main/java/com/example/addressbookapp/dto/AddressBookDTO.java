package com.example.addressbookapp.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

@Data
public class AddressBookDTO {

    @NotBlank(message = "Name cannot be empty")
    @Pattern(
            regexp = "^[A-Za-z ]{2,}$",
            message = "Name must contain only alphabets and at least 2 characters"
    )
    private String name;

    private String city;
    private String state;
}