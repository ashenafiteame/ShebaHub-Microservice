package com.example.shebahubuser.DTO.response;

import com.example.shebahubuser.model.Users;

public class AuthenticationResponse {

    Users user;
    String jwt;

    public AuthenticationResponse() {
    }

    public AuthenticationResponse(Users user, String jwt) {
        this.user = user;
        this.jwt = jwt;
    }

    public Users getUser() {
        return user;
    }

    public void setUser(Users user) {
        this.user = user;
    }

    public String getJwt() {
        return jwt;
    }

    public void setJwt(String jwt) {
        this.jwt = jwt;
    }
}
