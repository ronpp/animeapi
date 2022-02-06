package com.example.animeapi.services;

import com.example.animeapi.domains.models.Anime;
import com.example.animeapi.domains.models.projections.ProjectionAnime;
import com.example.animeapi.repositories.AnimeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Locale;
import java.util.function.Predicate;
import java.util.stream.Collectors;

@Service
public class AnimeService {

    @Autowired
    AnimeRepository animeRepository;


    public List<ProjectionAnime> getAnime(){
        return animeRepository.findBy();
    }


   public List<ProjectionAnime> getAnimeBy(Predicate<ProjectionAnime>...filters){
        Predicate<ProjectionAnime> myFilter = null;
        for (Predicate<ProjectionAnime> filter : filters) {
            if(myFilter == null){
                myFilter = filter;
            }else{
                myFilter.and(filter);
            }
        }

        return animeRepository.findBy().stream()
                .filter(myFilter)
                .collect(Collectors.toList());
    }

    public Predicate<ProjectionAnime> getAnimeByName(String name){
        return (Predicate<ProjectionAnime>) anime -> anime.getName().toLowerCase().equals(name);
    }

    public Predicate<ProjectionAnime> getAnimeByType(String type){
        return (Predicate<ProjectionAnime>) anime -> anime.getType().toLowerCase().equals(type);
    }

    public Predicate<ProjectionAnime> getAnimeByYear(Integer year){
        return (Predicate<ProjectionAnime>) anime -> anime.getYear_release().equals(year);
    }

    public Predicate<ProjectionAnime> getAnimeByGenre(String genre){
        return (Predicate<ProjectionAnime>) anime -> anime.getGenres().stream()
                .map(genres -> genres.getLabel().toLowerCase())
                .collect(Collectors.toList())
                .contains(genre);
    }

    public Predicate<ProjectionAnime> getAnimeByAuthor(String author){
        return (Predicate<ProjectionAnime>) anime -> anime.getAuthors().stream()
                .map(authors -> authors.getName().toLowerCase())
                .collect(Collectors.toList())
                .contains(author);
    }

}
