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
    private RecommendedRepository recommendedRepository;

    public List<?> getRecommended(){
        List<Recommended> recommendedList = recommendedRepository.findAll();
        Set<String> labels = recommendedList.stream()
                .map(recommended ->
                            genreRepository.findByGenreid(recommended.genreid, Genre.class).label)
                .collect(Collectors.toSet());
        List<RecommendedResponse> recommendedResp = labels.stream()
                .map(recommended -> {
                    RecommendedResponse rr = new RecommendedResponse();
                    rr.genre = recommended;
                    return rr;
                }).collect(Collectors.toList());

        for (RecommendedResponse rr : recommendedResp ) {
            for (Recommended recommended: recommendedList ) {
                String label =  genreRepository.findByGenreid(recommended.genreid, Genre.class).label;
                if (label.equals(rr.genre)){
                    Anime anime = animeRepository.findByAnimeid(recommended.animeid, Anime.class);
                    rr.animes.add(new AnimeSimpleData(anime.name, anime.type));
                }
            }
        }
        return  recommendedResp;
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
