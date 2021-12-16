package com.example.animeapi.domains.models.projections;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.Set;
import java.util.UUID;

public interface ProjectionUserDetail {

    UUID getUserid();
    String getUsername();

    @JsonIgnoreProperties("favoriteby")
   Set<ProjectionAnime> getFavorites();

}
