package com.example.animeapi.domains.models.projections;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import java.util.Set;
import java.util.UUID;

@JsonPropertyOrder({"genreid", "label"})
public interface ProjectionGenre {

    UUID getGenreid();
    String getLabel();

    @JsonIgnoreProperties({"genres", "description", "year_release"})
    Set<ProjectionAnime> getAnimes();

}
