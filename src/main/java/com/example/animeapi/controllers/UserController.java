package com.example.animeapi.controllers;

import com.example.animeapi.domains.dto.ListResult;
import com.example.animeapi.domains.models.User;
import com.example.animeapi.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
     private UserRepository userRepository;

    @GetMapping(path = "/")
    public ResponseEntity<?> getAllUser(){
        List<User> userList = userRepository.findAll();
        if(userList.size() != 0 ){
            return ResponseEntity.ok().body(ListResult.list(userList));
        }
        return ResponseEntity.ok().body(ListResult.list(new ArrayList<>()));
    }

    @PostMapping(path = "/")
    public ResponseEntity<?> addUser(@RequestBody  User user){

        return ResponseEntity.ok().body("");
    }
}
