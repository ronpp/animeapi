package com.example.animeapi.controllers;

import com.example.animeapi.domains.dto.DisplayMessage;
import com.example.animeapi.domains.dto.ListResult;
import com.example.animeapi.domains.models.User;
import com.example.animeapi.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
     private UserRepository userRepository;
    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @GetMapping(path = "/")
    public ResponseEntity<?> getAllUser(){
        List<User> userList = userRepository.findAll();
        if(userList.size() != 0 ){
            return ResponseEntity.ok().body(ListResult.list(userList));
        }
        return ResponseEntity.ok().body(ListResult.list(new ArrayList<>()));
    }

    @PostMapping(path = "/")
    public ResponseEntity<?> addUser(@RequestBody User newUser){

        if(userRepository.findByUsername(newUser.username) == null){
            User user = new User();
            user.username = newUser.username;
            user.password = passwordEncoder.encode(newUser.password);
            user.enabled = true;
            String userId = userRepository.save(user).userid.toString();
            return ResponseEntity.ok().body(DisplayMessage.message(newUser.toString()));
        }
        String message = String.format("Ja existeix un usuari amb el nom '%s'", newUser.username);
        return ResponseEntity.status(HttpStatus.CONFLICT).body(DisplayMessage.message(message));
    }
}
