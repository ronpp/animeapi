package com.example.animeapi.domains.dto;

public class UserResult {
    public String userid;
    public String username;

    public UserResult(String userid, String username) {
        this.userid = userid;
        this.username = username;
    }
    //TODO: Ask to Professor
    public static UserResult user(String userid, String username){
        return new UserResult( userid, username);
    }
}
