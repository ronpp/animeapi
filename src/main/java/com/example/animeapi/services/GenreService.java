package com.example.animeapi.services;


import com.example.animeapi.domains.models.projections.ProjectionGenre;
import com.example.animeapi.domains.models.projections.ProjectionGenreDetails;
import com.example.animeapi.repositories.GenreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class GenreService {

    @Autowired
    private GenreRepository genreRepository;


    public boolean ifExist(UUID genreId){
        return  genreRepository.existsById(genreId);
    }

    public List<ProjectionGenre> getAllGenre(){
        return genreRepository.findBy();
    }

    public ProjectionGenreDetails getGenre(UUID genreId){
       return genreRepository.findByGenreid(genreId, ProjectionGenreDetails.class);
    }
}
