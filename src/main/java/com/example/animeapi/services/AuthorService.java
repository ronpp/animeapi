package com.example.animeapi.services;

import com.example.animeapi.domains.models.projections.ProjectionAuthor;
import com.example.animeapi.domains.models.projections.ProjectionAuthorDetails;
import com.example.animeapi.repositories.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class AuthorService {

    @Autowired
    private AuthorRepository authorRepository;


    public boolean ifExist(UUID authorId){
        return authorRepository.existsById(authorId);
    }

    public List<ProjectionAuthor> getAllAuthor(){
        return authorRepository.findBy();
    }

    public ProjectionAuthorDetails getAuthor(UUID authorId){
        return authorRepository.findByAuthorid(authorId, ProjectionAuthorDetails.class);
    }
}
