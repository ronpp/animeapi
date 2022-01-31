package com.example.animeapi.services;

import com.example.animeapi.domains.dto.AnimeSimpleData;
import com.example.animeapi.domains.dto.RecommendedResponse;
import com.example.animeapi.domains.models.Anime;
import com.example.animeapi.domains.models.Genre;
import com.example.animeapi.domains.models.Recommended;
import com.example.animeapi.repositories.AnimeRepository;
import com.example.animeapi.repositories.GenreRepository;
import com.example.animeapi.repositories.RecommendedRepository;
import com.example.animeapi.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;


@Service
public class RecommendedService {

    @Autowired
    private GenreRepository genreRepository;
    @Autowired
    private AnimeRepository animeRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RecommendedRepository recommendedRepository;

    public List<?> getRecommended(){
        return recommendedRepository.findAll().stream()
                        .map(recom -> {
                            RecommendedResponse rr = new RecommendedResponse();
                            rr.genre = genreRepository.findByGenreid(recom.genreid, Genre.class).label;
                            Anime anime = animeRepository.findByAnimeid(recom.animeid, Anime.class);
                            rr.animes.add(new AnimeSimpleData(anime.name, anime.type));
                            return rr;
        }).collect(Collectors.toList());

    }

    public boolean validData(UUID animeID){
        Anime anime = animeRepository.findById(animeID).orElse(null);
        return anime != null;
    }

    public void save(UUID animeId,  UUID userId) {
        List<UUID> genres = animeRepository.findByAnimeid(animeId, Anime.class).genres.stream()
                       .map(genre -> genre.genreid)
                       .collect(Collectors.toList());

        Recommended recommended = new Recommended();
        genres.forEach(genre -> {
                    recommended.genreid = genre;
                    recommended.userid = userId;
                    recommended.animeid = animeId;
                    recommendedRepository.save(recommended);
                }
        );
    }
}
