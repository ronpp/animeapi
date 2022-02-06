package com.example.animeapi.services;

import com.example.animeapi.domains.models.projections.ProjectionAnime;
import com.example.animeapi.repositories.AnimeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

@Service
public class AnimeService {

    @Autowired
    AnimeRepository animeRepository;


    public List<ProjectionAnime> getAnime(){
        return animeRepository.findBy();
    }


   public List<ProjectionAnime> getAnimeBy(ArrayList<Predicate<ProjectionAnime>>filters){
        Predicate<ProjectionAnime> myFilter = null;
        for (Predicate<ProjectionAnime> filter : filters) {
            if(myFilter == null){
                myFilter = filter;
            }
            myFilter = myFilter.and(filter);
        }
        return animeRepository.findBy().stream()
                .filter(myFilter)
                .collect(Collectors.toList());
    }

    public Predicate<ProjectionAnime> getAnimeByName(String name){
        return anime -> anime.getName().toLowerCase().equals(name);
    }

    public Predicate<ProjectionAnime> getAnimeByType(String type){
        return anime -> anime.getType().toLowerCase().equals(type);
    }

    public Predicate<ProjectionAnime> getAnimeByYear(Integer year){
        return anime -> anime.getYear_release().equals(year);
    }

    public Predicate<ProjectionAnime> getAnimeByGenre(String genre){
        return anime -> anime.getGenres().stream()
                .map(genres -> genres.getLabel().toLowerCase())
                .collect(Collectors.toList())
                .contains(genre);
    }

    public Predicate<ProjectionAnime> getAnimeByAuthor(String author){
        return anime -> anime.getAuthors().stream()
                .map(authors -> authors.getName().toLowerCase())
                .collect(Collectors.toList())
                .contains(author);
    }

}
