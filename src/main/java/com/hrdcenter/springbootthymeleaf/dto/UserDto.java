package com.hrdcenter.springbootthymeleaf.dto;

import javax.validation.constraints.NotBlank;

public class UserDto {

    @NotBlank(message = "You have to give your username")
    private String username;

    @NotBlank(message = "You have to give your password")
    private String password;

    public UserDto() {}

    public UserDto(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "UserRegisterDto{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }

}
