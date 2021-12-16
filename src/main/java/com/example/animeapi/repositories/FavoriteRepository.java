package com.example.animeapi.repositories;

import com.example.animeapi.domains.models.Favorite;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface FavoriteRepository extends JpaRepository<Favorite, UUID> {

}
