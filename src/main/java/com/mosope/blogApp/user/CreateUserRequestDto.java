package com.mosope.blogApp.user;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class CreateUserRequestDto {
    @NotBlank(message = "firstname cannot be blank")
    private String firstName;

    @NotBlank(message = "lastname cannot be blank")
    private String lastName;

    @NotBlank(message = "username cannot be blank")
    private String username;

    @NotBlank(message = "email cannot be blank")
    private String email;

    @NotBlank(message = "password cannot be blank")
    private String password;
}
