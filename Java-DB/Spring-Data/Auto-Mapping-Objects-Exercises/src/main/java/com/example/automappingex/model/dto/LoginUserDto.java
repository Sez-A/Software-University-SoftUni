package com.example.automappingex.model.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.Pattern;

public class LoginUserDto {
    private String email;
    private String password;

    public LoginUserDto() {
    }

    public LoginUserDto(String email, String password) {
        this.email = email;
        this.password = password;
    }

    @Email
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Pattern(regexp = "[A-Za-z0-9]{6,}",
            message = "Password must be at least " +
                    "6 symbols and must contain at least " +
                    "1 uppercase, 1 lowercase letter and 1 digit.")
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
