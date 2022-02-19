package com.example.animeapi.domains.models.projections;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import java.util.Set;
import java.util.UUID;

@JsonPropertyOrder({"animeid", "name", "type", "episodes",  "imageurl"})
public interface ProjectionAnimeShort {
    UUID getAnimeid();
    String getName();
    String getType();
    Integer getEpisodes();
    String getImageurl();

    @JsonIgnoreProperties({"animes", "imageurl"})
    Set<ProjectionAuthor> getAuthors();


}
