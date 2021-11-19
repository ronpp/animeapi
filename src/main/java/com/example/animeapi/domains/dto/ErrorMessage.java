package com.example.animeapi.domains.dto;

public class ErrorMessage {

    public String message;

    public ErrorMessage(String message) {
        this.message = message;
    }

    public static ErrorMessage message(String message) {
        return new ErrorMessage(message);
    }
}
