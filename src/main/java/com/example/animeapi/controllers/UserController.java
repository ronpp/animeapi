package com.example.animeapi.controllers;

import com.example.animeapi.domains.dto.*;
import com.example.animeapi.services.AnimeService;
import com.example.animeapi.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;


import java.util.UUID;

@RestController
@RequestMapping("/users")
public class UserController {


    @Autowired
    private UserService userService;
    @Autowired
    private AnimeService animeService;



    @GetMapping("/")
    public ResponseEntity<?> getAllUser() {
        return ResponseEntity.ok().body(ListResult.list(userService.getAllUsers()));
    }


    @GetMapping("/{id}")
    public ResponseEntity<?> getUser(@PathVariable UUID id) {
        return ResponseEntity.ok().body(userService.getUserById(id));
    }


    @PostMapping("/")
    public ResponseEntity<?> addUser(@RequestBody RequestNewUser newUser) {

        if (!userService.ifExist(newUser.username)) {
            return ResponseEntity.ok().body(userService.addNewUser(newUser));
        }
        return ResponseEntity.status(HttpStatus.CONFLICT)
                .body(DisplayMessage.message(String.format("Ja existeix un usuari amb el nom '%s'", newUser.username)));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteUser(@PathVariable UUID id) {
        if (userService.getUserById(id) != null) {
            userService.deleteUser(id);
            return ResponseEntity.ok()
                    .body(DisplayMessage.message( String.format("S'ha eliminat l'usuari amd id '%s'", id)));
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(DisplayMessage.message(String.format("No s'ha trobat l'usuari amd id '%s'", id)));
    }

    @DeleteMapping("/")
    public ResponseEntity<?> deleteAllUser() {
        userService.deleteAllUser();
        return ResponseEntity.ok().build();
    }

    // Login
    @GetMapping("/login")
    public ResponseEntity<?> login() {
        return ResponseEntity.ok().build();
    }



    // FAVORITES

    @GetMapping("/favorites")
    public ResponseEntity<?>getFavorite(Authentication authentication){
        return ResponseEntity.ok().body(ListResult.list(userService.getUserFavorites(authentication.getName())));
    }


    @PostMapping("/favorites")
    public ResponseEntity<?> addFavorite(@RequestBody RequestFavorite favorite, Authentication authentication) {
        if (animeService.getAnimeById(favorite.animeid) != null){
            return ResponseEntity.ok().body(userService.addFavoriteToUser(favorite, authentication.getName()));
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(DisplayMessage.message(String.format("No s 'ha trobat l' anime amd id '%s'", favorite.animeid)));
    }


    @DeleteMapping("/favorites/{id}")
    public ResponseEntity<?> deleteFavorite(@PathVariable UUID id, Authentication authentication) {
        if (animeService.getAnimeById(id) != null) {
            userService.deleteFavorite(id, authentication.getName());
            return ResponseEntity.ok()
                    .body(DisplayMessage.message(String.format("S'ha eliminat dels favorits l'anime amd id '%s'", id)));
        }

        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(DisplayMessage.message(String.format("No s 'ha trobat l'id '%s'", id)));
    }



}
