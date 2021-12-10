package com.example.animeapi.repositories;

import com.example.animeapi.domains.models.Genre;
import com.example.animeapi.domains.models.projections.ProjectionGenre;
import com.example.animeapi.domains.models.projections.ProjectionGenreDetails;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface GenreRepository extends JpaRepository<Genre, UUID> {

    List<ProjectionGenre>findBy();
    ProjectionGenreDetails findByGenreid(UUID id);
}
