package com.example.animeapi.domains.models.projections;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import java.util.Set;
import java.util.UUID;

@JsonPropertyOrder({"label"})
public interface ProjectionRecommended {

    String getLabel();

    @JsonIgnoreProperties({"animeid", "authors"})
    Set<ProjectionAnimeShort> getAnimes();
}
