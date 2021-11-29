package com.example.animeapi.controllers;


import com.example.animeapi.domains.dto.ListResult;
import com.example.animeapi.domains.models.Author;
import com.example.animeapi.repositories.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/authors")
public class AuthorController {
    @Autowired
    private AuthorRepository AuthorRepository;

    @GetMapping("/")
    public ResponseEntity<?> getAllAuthor() {
        List<Author> animeList = AuthorRepository.findAll();
        return ResponseEntity.ok().body(ListResult.list(animeList));

    }



}
