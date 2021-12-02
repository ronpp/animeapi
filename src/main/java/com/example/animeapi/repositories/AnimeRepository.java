package com.example.animeapi.repositories;

import com.example.animeapi.domains.models.Anime;
import com.example.animeapi.domains.models.projections.ProjectionAnime;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface AnimeRepository extends JpaRepository<Anime, UUID> {

    Anime findByname(String name);
    List<ProjectionAnime>findBy();
    ProjectionAnime findByAnimeid(UUID id);
}
