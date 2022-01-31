package com.example.animeapi.repositories;

import com.example.animeapi.domains.models.Recommended;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface RecommendedRepository extends JpaRepository<Recommended, UUID> {
}
