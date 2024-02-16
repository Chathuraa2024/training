package com.company.SpringSecurity.dto.ResponseDto;

import com.company.SpringSecurity.Module.User;
import lombok.Data;

import java.util.Optional;

@Data
public class loginResponse {
    private Optional<User> user;
    private String jwtToken;


    public loginResponse(Optional<User> user, String jwtToken) {
        this.user = user;
        this.jwtToken = jwtToken;
    }





}
