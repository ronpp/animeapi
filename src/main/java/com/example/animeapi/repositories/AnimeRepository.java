package com.example.animeapi.repositories;

import com.example.animeapi.domains.models.Anime;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface AnimeRepository  extends JpaRepository<Anime, UUID> {

    Anime findByname(String name);
}
