package com.example.animeapi.domains.models.projections;

import com.example.animeapi.domains.models.Favorite;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.Set;
import java.util.UUID;

public interface ProjectionUser {

    UUID getUserid();
    String getUsername();

    @JsonIgnoreProperties("favoriteby")
    Set<ProjectionAnimeShort> getFavorites();

}
