package com.example.animeapi.controllers;

import com.example.animeapi.domains.dto.*;
import com.example.animeapi.domains.models.projections.ProjectionAnime;
import com.example.animeapi.services.AnimeService;
import com.example.animeapi.services.RecommendedService;
import com.example.animeapi.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.function.Predicate;


@RestController
@RequestMapping("/animes")
public class AnimeController {


    @Autowired
    AnimeService animeService;
    @Autowired
    private UserService userService;
    @Autowired
    private RecommendedService recommendedService;

    @GetMapping("/")
    public ResponseEntity<?> getAllAnime() {
        List<ProjectionAnime> animeList = animeService.getAnime();
        return ResponseEntity.ok().body(ListResult.list(animeList));

    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getAnime(@PathVariable UUID id) {
        ProjectionAnime anime = animeService.getAnimeById(id);
        if (anime != null) {
            return ResponseEntity.ok().body(anime);
        }
        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body(DisplayMessage.message(String.format("No s 'ha trobat l' anime amd id %s", id)));
    }

    @PostMapping("/")
    public ResponseEntity<?> addAnime(@RequestBody RequestAnimeCreate anime) {
        if (animeService.existAnime(anime.name)){
            return ResponseEntity.ok().body(animeService.saveAnime(anime));
        }
        return ResponseEntity.status(HttpStatus.CONFLICT)
                .body(DisplayMessage.message(String.format("Ja existeix un anime amb el nom '%s' ", anime.name)));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteAnime(@PathVariable UUID id) {
        if (animeService.deleteAnime(id)) {
            return ResponseEntity.ok()
                    .body(DisplayMessage.message(String.format("S'ha eliminat l'anime amd id '%s'", id)));
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(DisplayMessage.message(String.format("No s 'ha trobat l' anime amd id %s", id)));
    }


    // RECOMMENDED

    @GetMapping("/recommended")
    public ResponseEntity<?> getRecommended(){
        return ResponseEntity.ok().body(ListResult.list(recommendedService.getRecommended()));
    }

    @PostMapping("/recommended")
    public ResponseEntity<?> addRecommended(@RequestBody RequestRecommended anime, Authentication authentication){

        if (userService.ifExist(authentication.getName())){
          if(animeService.getAnimeById(anime.animeid) != null){
            UUID userid = userService.getUserId(authentication.getName());
            recommendedService.save(anime.animeid, userid);
            String animeName = animeService.getAnimeById(anime.animeid).getName();
            return ResponseEntity.ok().body(DisplayMessage.message(String.format("Added '%s' to recommended list", animeName)));
          }else{
              return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(DisplayMessage.message("The id entered is not valid"));
          }
        }
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(DisplayMessage.message("You need to be registered to perform this action"));
    }


    // Rating

    @GetMapping("/rating")
    public ResponseEntity<?> getAnimeRating(){
        return ResponseEntity.ok().body(ListResult.list(animeService.getRatingAnime()));
    }

    @PostMapping("/rating")
    public ResponseEntity<?> addAnimeRating(@RequestBody RequetRating requetRating, Authentication authentication){
        if(!animeService.existAnime(requetRating.anime)){
            animeService.AddRatingAnime(requetRating, authentication.getName());
            return ResponseEntity.ok().body(DisplayMessage.message(String.format("Added rating to anime '%s'", requetRating.anime)));
        }
       return ResponseEntity.status(HttpStatus.NOT_FOUND).body(DisplayMessage.message(String.format("The anime '%s' don't exist", requetRating.anime)));

    }


    // SEARCH
    @GetMapping("/search")
   public ResponseEntity<?> searchAnime(@RequestParam (required = false)String name, @RequestParam(required = false) String genre,
                                  @RequestParam (required = false) Integer year,  @RequestParam (required = false)String type,
                                    @RequestParam (required = false) String author){


       ArrayList< Predicate<ProjectionAnime>> filters = new ArrayList<>();

        if(name == null && genre == null && year == null && type == null && author == null){
            return ResponseEntity.ok().body(ListResult.list(animeService.getAnime()));
        }
        if (name != null && !name.equals("") ) {
           filters.add(animeService.findAnimeByName(name));
        }
        if (type != null && !type.equals("")) {
           filters.add(animeService.findAnimeByType(type));
        }
        if (year != null && !String.valueOf(year).equals("")) {
           filters.add(animeService.findAnimeByYear(year));
        }
        if (genre != null && !genre.equals("")) {
            filters.add(animeService.findAnimeByGenre(genre));
        }
        if (author != null && !author.equals("")) {
           filters.add(animeService.findAnimeByAuthor(author));
        }
        return ResponseEntity.ok().body(ListResult.list(animeService.findAnimeBy(filters)));

    }

}
