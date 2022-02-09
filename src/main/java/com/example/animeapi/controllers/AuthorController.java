package com.example.animeapi.controllers;


import com.example.animeapi.domains.dto.DisplayMessage;
import com.example.animeapi.domains.dto.ListResult;
import com.example.animeapi.domains.models.projections.ProjectionAuthor;
import com.example.animeapi.domains.models.projections.ProjectionAuthorDetails;
import com.example.animeapi.repositories.AuthorRepository;
import com.example.animeapi.services.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;


@RestController
@RequestMapping("/authors")
public class AuthorController {
    @Autowired
    private AuthorService authorService;

    @GetMapping("/")
    public ResponseEntity<?> getAllAuthor() {
        return ResponseEntity.ok().body(ListResult.list(authorService.getAllAuthor()));

    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getAuthor(@PathVariable UUID id) {
        if (authorService.ifExist(id)) {
            return ResponseEntity.ok().body(authorService.getAuthor(id));
        }
        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body(DisplayMessage.message(String.format("No s 'ha trobat l' author amd id %s", id)));
    }

}
