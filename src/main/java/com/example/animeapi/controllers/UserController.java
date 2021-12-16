package com.example.animeapi.controllers;

import com.example.animeapi.domains.dto.DisplayMessage;
import com.example.animeapi.domains.dto.ListResult;
import com.example.animeapi.domains.dto.UserResult;
import com.example.animeapi.domains.models.User;
import com.example.animeapi.domains.models.projections.ProjectionUser;
import com.example.animeapi.domains.models.projections.ProjectionUserDetail;
import com.example.animeapi.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @GetMapping("/")
    public ResponseEntity<?> getAllUser() {
        List<ProjectionUser> userList = userRepository.findBy();
        return ResponseEntity.ok().body(ListResult.list(userList));
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getUser(@PathVariable UUID id) {
        return ResponseEntity.ok().body(ListResult.list(userRepository.findByUserid(id, ProjectionUserDetail.class)));
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

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteUser(@PathVariable UUID id) {
        User user = userRepository.findById(id).orElse(null);
        if (user != null) {
            userRepository.deleteById(id);
            return ResponseEntity.ok()
                    .body(DisplayMessage.message( String.format("S'ha eliminat l'usuari amd id '%s'", id)));
        }

        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(DisplayMessage.message(String.format("No s'ha trobat l'usuari amd id %s", id)));
    }

    @DeleteMapping("/")
    public ResponseEntity<?> deleteAllUser() {
        userRepository.deleteAll();
        return ResponseEntity.ok().build();
    }
}
