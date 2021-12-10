package com.example.animeapi.domains.models.projections;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import java.util.Set;
import java.util.UUID;

@JsonPropertyOrder({"genreid", "label"})
public interface ProjectionGenreDetails {

    UUID getGenreid();
    String getLabel();

    @JsonIgnoreProperties("genres")
    Set<ProjectionAnimeDetails> getAnimes();

}
