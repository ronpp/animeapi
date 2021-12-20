package com.example.animeapi.domains.models.projections;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import java.util.Set;


@JsonPropertyOrder({"name", "description", "type"})
public interface ProjectionFavorite {
    String getName();
    String getType();

    @JsonIgnoreProperties({"animes", "authorid","imageurl"})
    Set<ProjectionAuthor> getAuthors();


}
