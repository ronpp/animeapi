package com.example.animeapi.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.Entity;
import javax.persistence.Table;

@RestController
@RequestMapping("/animes")
public class AnimeController {

    @GetMapping(path = "/")
    public String helloWord(){
        return "Hello word!";
    }


}
