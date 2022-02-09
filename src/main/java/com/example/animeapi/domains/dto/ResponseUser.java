package com.example.animeapi.domains.dto;

import com.example.animeapi.domains.models.User;

public class ResponseUser {
    public String userid;
    public String username;

    private ResponseUser(User user) {
        this.userid = user.userid.toString();
        this.username = user.username;
    }

    public static ResponseUser user(User user) {
        return new ResponseUser(user);
    }
}
