package com.example.animeapi.controllers;


import com.example.animeapi.domains.dto.DisplayMessage;
import com.example.animeapi.domains.dto.ListResult;
import com.example.animeapi.domains.models.projections.ProjectionAuthor;
import com.example.animeapi.repositories.AuthorRepository;
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
    private AuthorRepository AuthorRepository;

    @GetMapping("/")
    public ResponseEntity<?> getAllAuthor() {
        List<ProjectionAuthor> authorList = AuthorRepository.findBy();
        return ResponseEntity.ok().body(ListResult.list(authorList));

    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getAuthor(@PathVariable UUID id) {
        ProjectionAuthor author = AuthorRepository.findByAuthorid(id);
        if (author != null) {
            return ResponseEntity.ok().body(author);
        }
        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body(DisplayMessage.message(String.format("No s 'ha trobat l' author amd id %s", id)));
    }

}
