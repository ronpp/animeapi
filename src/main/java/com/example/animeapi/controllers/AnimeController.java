package com.example.animeapi.controllers;

import com.example.animeapi.domains.dto.DisplayMessage;
import com.example.animeapi.domains.dto.ListResult;
import com.example.animeapi.domains.models.Anime;
import com.example.animeapi.domains.models.projections.ProjectionAnime;
import com.example.animeapi.domains.models.projections.ProjectionAnimeShort;
import com.example.animeapi.repositories.AnimeRepository;
import com.example.animeapi.services.AnimeService;
import com.example.animeapi.services.RecommendedService;
import com.example.animeapi.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;


@RestController
@RequestMapping("/animes")
public class AnimeController {
    @Autowired
    private AnimeRepository animeRepository;

    @Autowired
    AnimeService animeService;
    @Autowired
    private UserService userService;
    @Autowired
    private RecommendedService recommendedService;

    @GetMapping("/")
    public ResponseEntity<?> getAllAnime() {
        List<ProjectionAnime> animeList = animeRepository.findBy();
        return ResponseEntity.ok().body(ListResult.list(animeList));

    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getAnime(@PathVariable UUID id) {
        ProjectionAnime anime = animeRepository.findByAnimeid(id, ProjectionAnime.class);
        if (anime != null) {
            return ResponseEntity.ok().body(anime);
        }
        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body(DisplayMessage.message(String.format("No s 'ha trobat l' anime amd id %s", id)));
    }

    @PostMapping("/")
    public ResponseEntity<?> addAnime(@RequestBody Anime anime) { // TODO: Revisar, no requerir entidades
        if (animeRepository.findByname(anime.name) == null)
            return ResponseEntity.ok().body(animeRepository.save(anime));

        return ResponseEntity.status(HttpStatus.CONFLICT)
                .body(DisplayMessage.message(String.format("Ja existeix un anime amb el nom '%s' ", anime.name)));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteAnime(@PathVariable UUID id) {
        Anime anime = animeRepository.findById(id).orElse(null);
        if (anime != null) {
            animeRepository.deleteById(id);
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
    public ResponseEntity<?> addRecommended(@RequestBody Anime anime, Authentication authentication){

        if (userService.ifExist(authentication.getName())){
          if(recommendedService.validData(anime.animeid)){
            UUID userid = userService.getUserId(authentication.getName());
            recommendedService.save(anime.animeid, userid);
            String animeName = animeRepository.findByAnimeid(anime.animeid, ProjectionAnimeShort.class).getName();
            return ResponseEntity.ok().body(DisplayMessage.message(String.format("Added '%s' to recommended list", animeName)));
          }else{
              return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(DisplayMessage.message("The data entered is not correct"));
          }
        }
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(DisplayMessage.message("You need to be registered to perform this action"));
    }


    // SEARCH
    @GetMapping("/search")
   public ResponseEntity<?> searchAnime(@RequestParam (required = false)String name, @RequestParam(required = false) String genre,
                                  @RequestParam (required = false) Integer year,  @RequestParam (required = false)String type,
                                    @RequestParam (required = false) String author){

        if(name == null && genre == null && year == null && type == null && author == null){
            return ResponseEntity.ok().body(ListResult.list(animeService.getAnime()));
        }
        if (name != null) {
            return ResponseEntity.ok().body(ListResult.list(animeService.getAnimeBy(animeService.getAnimeByName(name))));
        }
        if (type != null) {
            return ResponseEntity.ok().body(ListResult.list(animeService.getAnimeBy(animeService.getAnimeByType(type))));
        }
        if (year != null) {
            return ResponseEntity.ok().body(ListResult.list(animeService.getAnimeBy(animeService.getAnimeByYear(year))));
        }
        if (genre != null) {
            return ResponseEntity.ok().body(ListResult.list(animeService.getAnimeBy(animeService.getAnimeByGenre(genre))));
        }
        if (author != null) {
            return ResponseEntity.ok().body(ListResult.list(animeService.getAnimeBy(animeService.getAnimeByAuthor(author))));
        }

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(DisplayMessage.message("Not found any anime with the filter specified"));
    }

}
