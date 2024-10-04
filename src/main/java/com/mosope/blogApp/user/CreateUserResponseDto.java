package com.mosope.blogApp.user;

import lombok.Data;

@Data
public class CreateUserResponseDto {
    private String firstName;
    private String lastName;
    private String username;
    private String email;
}
