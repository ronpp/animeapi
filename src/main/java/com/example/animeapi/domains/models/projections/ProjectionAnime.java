package com.example.animeapi.domains.models.projections;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import java.util.Set;
import java.util.UUID;

@JsonPropertyOrder({"animeid", "name", "type", "year_release", "episodes" ,"imageurl", "description"})
public interface ProjectionAnime {
    UUID getAnimeid();
    String getName();
    String getDescription();
    String getType();
    Integer getYear_release();
    Integer getEpisodes();
    String getImageurl();

    @JsonIgnoreProperties("animes")
    Set<ProjectionAuthor> getAuthors();

    @JsonIgnoreProperties("animes")
    Set<ProjectionGenre> getGenres();


}
