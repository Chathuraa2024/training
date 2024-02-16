package com.company.SpringSecurity.dto.RequestDto;

import lombok.Data;

@Data
public class loginRequest {
    private String username;
    private String userPassword;


    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }


}
