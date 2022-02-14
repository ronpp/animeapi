package com.example.animeapi.services;

import com.example.animeapi.domains.dto.RequestAnimeCreate;
import com.example.animeapi.domains.dto.ResponseRating;
import com.example.animeapi.domains.models.Anime;
import com.example.animeapi.domains.models.Rating;
import com.example.animeapi.domains.models.projections.ProjectionAnime;
import com.example.animeapi.repositories.AnimeRepository;
import com.example.animeapi.repositories.RatingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.function.Predicate;
import java.util.stream.Collectors;

@Service
public class AnimeService {

    @Autowired
    AnimeRepository animeRepository;

    @Autowired
    RatingRepository ratingRepository;


    // Animes
    public List<ProjectionAnime> getAnime(){
        return animeRepository.findBy();
    }

    public ProjectionAnime getAnimeById(UUID animeID){
        return animeRepository.findByAnimeid(animeID, ProjectionAnime.class);
    }

    public Anime saveAnime(RequestAnimeCreate anime){
        return animeRepository.save(Anime.fromRequest(anime));
    }


    public boolean deleteAnime(UUID id){
        Anime anime = animeRepository.findById(id).orElse(null);
        if (anime != null) {
            animeRepository.deleteById(id);
            return true;
        }
        return false;
    }

    public boolean existAnime(String name) {
        return animeRepository.findByname(name) == null;
    }



    // Rating
    public List<ResponseRating>getRatingAnime(){
        return ratingRepository.findBy().stream()
                .collect(Collectors.groupingBy(Rating::getAnime, Collectors.averagingDouble(Rating::getScore)))
                .entrySet().stream()
                .map(entry -> new ResponseRating(entry.getKey(),Math.round(entry.getValue()*100.0)/100.0))
                .collect(Collectors.toList());

    }

    // Search
   public List<ProjectionAnime> findAnimeBy(ArrayList<Predicate<ProjectionAnime>>filters){
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

    public Predicate<ProjectionAnime> findAnimeByName(String name){
        return anime -> anime.getName().toLowerCase().equals(name);
    }

    public Predicate<ProjectionAnime> findAnimeByType(String type){
        return anime -> anime.getType().toLowerCase().equals(type);
    }

    public Predicate<ProjectionAnime> findAnimeByYear(Integer year){
        return anime -> anime.getYear_release().equals(year);
    }

    public Predicate<ProjectionAnime> findAnimeByGenre(String genre){
        return anime -> anime.getGenres().stream()
                .map(genres -> genres.getLabel().toLowerCase())
                .collect(Collectors.toList())
                .contains(genre);
    }

    public Predicate<ProjectionAnime> findAnimeByAuthor(String author){
        return anime -> anime.getAuthors().stream()
                .map(authors -> authors.getName().toLowerCase())
                .collect(Collectors.toList())
                .contains(author);
    }


}
