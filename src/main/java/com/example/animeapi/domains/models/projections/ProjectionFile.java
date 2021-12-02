package com.example.animeapi.domains.models.projections;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import java.util.UUID;
@JsonPropertyOrder({"fileid", "contenttype"})
public interface ProjectionFile {

    UUID getFileid();
    String getContenttype();

}
