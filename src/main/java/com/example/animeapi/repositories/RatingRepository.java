package com.example.animeapi.repositories;

import com.example.animeapi.domains.models.Rating;
import com.example.animeapi.domains.models.projections.ProjectionRating;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RatingRepository extends JpaRepository<Rating, String> {

    List<ProjectionRating> findBy();
}
