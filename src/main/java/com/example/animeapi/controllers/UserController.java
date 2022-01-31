package com.example.animeapi.controllers;

import com.example.animeapi.domains.dto.DisplayMessage;
import com.example.animeapi.domains.dto.ListResult;
import com.example.animeapi.domains.dto.UserResult;
import com.example.animeapi.domains.models.Anime;
import com.example.animeapi.domains.models.Favorite;
import com.example.animeapi.domains.models.User;
import com.example.animeapi.domains.models.projections.ProjectionFavorite;
import com.example.animeapi.domains.models.projections.ProjectionUser;
import com.example.animeapi.domains.models.projections.ProjectionUserDetail;
import com.example.animeapi.repositories.AnimeRepository;
import com.example.animeapi.repositories.FavoriteRepository;
import com.example.animeapi.repositories.UserRepository;
import com.example.animeapi.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;


import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private AnimeRepository animeRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private FavoriteRepository favoriteRepository;
    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @Autowired
    private UserService userService;

    @GetMapping("/")
    public ResponseEntity<?> getAllUser() {
        List<ProjectionUser> userList = userRepository.findBy();
        return ResponseEntity.ok().body(ListResult.list(userList));
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getUser(@PathVariable UUID id) {
        return ResponseEntity.ok().body(ListResult.list(userRepository.findByUserid(id, ProjectionUserDetail.class)));
    }


    @GetMapping("/favorites")
    public ResponseEntity<?>getFavorite(Authentication authentication){
        UUID userID = userRepository.findByUsername(authentication.getName()).userid;
        List<Favorite> favorites = favoriteRepository.findByUserid(userID);
        List<ProjectionFavorite> favoritesAnime = favorites
                                                    .stream()
                                                    .map(fav -> animeRepository.findByAnimeid(fav.animeid, ProjectionFavorite.class))
                                                    .collect(Collectors.toList());
        return ResponseEntity.ok().body(ListResult.list(favoritesAnime));
    }


    @PostMapping("/")
    public ResponseEntity<?> addUser(@RequestBody User newUser) {

        if (userRepository.findByUsername(newUser.username) == null) {
            User user = new User();
            user.username = newUser.username;
            user.password = passwordEncoder.encode(newUser.password);
            user.enabled = true;
            userRepository.save(user);
            UserResult userResponse = UserResult.user(user);
            return ResponseEntity.ok().body(userResponse);
        }
        return ResponseEntity.status(HttpStatus.CONFLICT)
                .body(DisplayMessage.message(String.format("Ja existeix un usuari amb el nom '%s'", newUser.username)));
    }

    @PostMapping("/favorite")
    public ResponseEntity<?> addFavorite(@RequestBody Favorite favorite, Authentication authentication) {
        UUID userID = userRepository.findByUsername(authentication.getName()).userid;
        if (animeRepository.findByAnimeid(favorite.animeid, UUID.class) != null){
            favorite.userid =  userID;
            favoriteRepository.save(favorite);
            return ResponseEntity.ok().body(favorite);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(DisplayMessage.message(String.format("No s 'ha trobat l' anime amd id '%s'", favorite.animeid)));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteUser(@PathVariable UUID id) {
        User user = userRepository.findById(id).orElse(null);
        if (user != null) {
            userRepository.deleteById(id);
            return ResponseEntity.ok()
                    .body(DisplayMessage.message( String.format("S'ha eliminat l'usuari amd id '%s'", id)));
        }

        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(DisplayMessage.message(String.format("No s'ha trobat l'usuari amd id '%s'", id)));
    }

    @DeleteMapping("/")
    public ResponseEntity<?> deleteAllUser() {
        userRepository.deleteAll();
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/favorite/{id}")
    public ResponseEntity<?> deleteFavorite(@PathVariable UUID id, Authentication authentication) {
        if (userService.ifExist(authentication.getName())) {
            Favorite favorite = new Favorite();
            favorite.userid =  userService.getUserId(authentication.getName());
            favorite.animeid = id;
            favoriteRepository.delete(favorite);
            return ResponseEntity.ok()
                    .body(DisplayMessage.message(String.format("S'ha eliminat dels favorits l'anime amd id '%s'", id)));
        }

        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(DisplayMessage.message(String.format("No s 'ha trobat l'id '%s'", id)));
    }

}
