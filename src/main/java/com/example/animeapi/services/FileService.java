package com.example.animeapi.services;

import com.example.animeapi.domains.models.projections.ProjectionFile;
import com.example.animeapi.repositories.FileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FileService {

    @Autowired
    private FileRepository fileRepository;


    public List<ProjectionFile> getAllFile(){
        return fileRepository.findBy();
    }

    public List<ProjectionFile> getFile(){
        return fileRepository.findBy();
    }
}
