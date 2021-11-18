package com.example.animeapi.controllers;

import com.example.animeapi.domains.dto.ListResult;
import com.example.animeapi.domains.models.Anime;
import com.example.animeapi.repositories.AnimeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/animes")
public class AnimeController {
    @Autowired
    private AnimeRepository animeRepository;

    @GetMapping(path = "/")
    public ResponseEntity<?> getAllAnime(){
        List<Anime> animeList = animeRepository.findAll();
        if (animeList.size() != 0){
            return ResponseEntity.ok().body(ListResult.list(animeList));
        }
        return ResponseEntity.ok().body(ListResult.list(new ArrayList<>()));
    }


    @GetMapping(path = "/{id}")
    public ResponseEntity<?>getAnime(@PathVariable UUID id){
        Anime anime = animeRepository.findById(id).orElse(null);
        if(anime != null){
            return ResponseEntity.ok().body(anime);
        }
        String errorMessage = String.format("{ \"message\": \"No s 'ha trobat l' anime amd id %s \"  }", id.toString());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorMessage);
    }


    @PostMapping(path = "/")
    public ResponseEntity<?>addAnime(@RequestBody Anime anime){
        return ResponseEntity.ok().body(animeRepository.save(anime));
    }

}
