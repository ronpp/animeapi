package com.example.animeapi.services;

import com.example.animeapi.domains.models.Anime;
import com.example.animeapi.domains.models.projections.ProjectionAnime;
import com.example.animeapi.repositories.AnimeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

@Service
public class AnimeService {

    @Autowired
    AnimeRepository animeRepository;

   public List<ProjectionAnime> getAnimeBy(String name, String genre, Integer year, String type, String author){
        Predicate<ProjectionAnime> filte = anime -> anime.getName().equals(name);

        if(type.equals("")){
           filte.and(anime -> anime.getType().equals(type));
        }

        return animeRepository.findBy().stream()
                .filter(filte)
                .collect(Collectors.toList());
    }
}
