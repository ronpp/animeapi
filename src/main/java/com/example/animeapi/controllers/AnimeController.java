package com.example.animeapi.controllers;

import com.example.animeapi.domains.dto.ListResult;
import com.example.animeapi.domains.models.Anime;
import com.example.animeapi.repositories.AnimeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/animes")
public class AnimeController {
    @Autowired
    private AnimeRepository animeRepository;

    @GetMapping(path = "/")
    public ResponseEntity<?> getAnime(){
        List<Anime> animeList = animeRepository.findAll();
        if (animeList.size() != 0){
            return ResponseEntity.ok().body(ListResult.list(animeList));
        }
        return ResponseEntity.ok().body(ListResult.list(new ArrayList<>()));
    }


}
