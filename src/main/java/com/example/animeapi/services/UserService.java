package com.example.animeapi.services;


import com.example.animeapi.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public boolean ifExist(String username){
        return userRepository.findByUsername(username) != null;
    }

    public UUID getUserId(String username){
        return userRepository.findByUsername(username).userid;
    }
}
