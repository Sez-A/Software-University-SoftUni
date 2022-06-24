package com.example.battleShips.model.binding;

import javax.validation.constraints.Size;

public class UserLoginBindingModel {
    private String username;
    private String password;

    @Size(min = 3, max = 10, message = "Username length must be between 3 and 10 characters")
    public String getUsername() {
        return username;
    }

    public UserLoginBindingModel setUsername(String username) {
        this.username = username;
        return this;
    }

    @Size(min = 3, message = "Password length must be more than 3 characters")
    public String getPassword() {
        return password;
    }

    public UserLoginBindingModel setPassword(String password) {
        this.password = password;
        return this;
    }
}
