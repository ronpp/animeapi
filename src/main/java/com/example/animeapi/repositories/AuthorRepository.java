package com.example.animeapi.repositories;

import com.example.animeapi.domains.models.Author;
import com.example.animeapi.domains.models.projections.ProjectionAuthor;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface AuthorRepository extends JpaRepository<Author, UUID> {

    List<ProjectionAuthor>findBy();
    ProjectionAuthor findByAuthorid(UUID id);
}
