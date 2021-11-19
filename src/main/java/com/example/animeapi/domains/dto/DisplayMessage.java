package com.example.animeapi.domains.dto;

public class DisplayMessage {

    public String message;

    public DisplayMessage(String message) {
        this.message = message;
    }

    public static DisplayMessage message(String message) {
        return new DisplayMessage(message);
    }
}
