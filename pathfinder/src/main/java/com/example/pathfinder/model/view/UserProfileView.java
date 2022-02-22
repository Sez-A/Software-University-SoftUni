package com.example.pathfinder.model.view;

import com.example.pathfinder.model.entity.enums.LevelEnum;

public class UserProfileView {
    private LevelEnum level;
    private String fullName;
    private String username;
    private Integer age;


    public LevelEnum getLevel() {
        return level;
    }

    public UserProfileView setLevel(LevelEnum level) {
        this.level = level;
        return this;
    }

    public String getFullName() {
        return fullName;
    }

    public UserProfileView setFullName(String fullName) {
        this.fullName = fullName;
        return this;
    }

    public String getUsername() {
        return username;
    }

    public UserProfileView setUsername(String username) {
        this.username = username;
        return this;
    }

    public Integer getAge() {
        return age;
    }

    public UserProfileView setAge(Integer age) {
        this.age = age;
        return this;
    }
}
