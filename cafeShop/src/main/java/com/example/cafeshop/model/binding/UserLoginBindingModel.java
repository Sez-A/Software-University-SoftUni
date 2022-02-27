package com.example.cafeshop.model.binding;

import javax.validation.constraints.Size;

public class UserLoginBindingModel {
    private String username;
    private String password;

    @Size(min = 3, max = 20)
    public String getUsername() {
        return username;
    }

    public UserLoginBindingModel setUsername(String username) {
        this.username = username;
        return this;
    }

    @Size(min = 3)
    public String getPassword() {
        return password;
    }

    public UserLoginBindingModel setPassword(String password) {
        this.password = password;
        return this;
    }
}
