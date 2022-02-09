package com.example.animeapi.controllers;


import com.example.animeapi.domains.dto.DisplayMessage;
import com.example.animeapi.domains.dto.ListResult;
import com.example.animeapi.services.GenreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import java.util.UUID;


@RestController
@RequestMapping("/genres")
public class GenreController {
    @Autowired
    private GenreService genreService;

    @GetMapping("/")
    public ResponseEntity<?> getAllGenre() {
        return ResponseEntity.ok().body(ListResult.list(genreService.getAllGenre()));

    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getGenre(@PathVariable UUID id) {
        if (genreService.ifExist(id)) {
            return ResponseEntity.ok().body(genreService.getGenre(id));
        }
        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body(DisplayMessage.message(String.format("No s 'ha trobat l' genre amd id %s", id)));
    }

}
