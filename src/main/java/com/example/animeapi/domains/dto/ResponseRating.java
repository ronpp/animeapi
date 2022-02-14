package com.example.animeapi.domains.dto;

public class ResponseRating {

    public String anime;
    public Double score;

    public ResponseRating(String anime, Double score) {
        this.anime = anime;
        this.score = score;
    }

}
