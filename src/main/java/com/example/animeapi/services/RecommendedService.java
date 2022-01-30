package com.example.animeapi.services;

import com.example.animeapi.domains.models.projections.ProjectionRecommended;
import com.example.animeapi.repositories.GenreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


@Service
public class RecommendedService {

    @Autowired
    private GenreRepository genreRepository;

    public List<?> getRecommended(){
        List<ProjectionRecommended> recommended = genreRepository.findBy().stream()
                .map(genre -> {
                    return genreRepository.findByGenreid(genre.getGenreid(), ProjectionRecommended.class);})
                .collect(Collectors.toList());
        return  recommended;
    }


}
