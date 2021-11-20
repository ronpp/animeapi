package com.example.animeapi.domains.dto;

public class GetUser {
    public String userid;
    public String username;

    public GetUser(String userid, String username) {
        this.userid = userid;
        this.username = username;
    }

    public static GetUser user(String userid, String username){
        return new GetUser( userid, username);
    }
}
