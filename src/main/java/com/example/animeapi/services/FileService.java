package com.example.animeapi.services;

import com.example.animeapi.domains.dto.FileResult;
import com.example.animeapi.domains.models.File;
import com.example.animeapi.domains.models.projections.ProjectionFile;
import com.example.animeapi.repositories.FileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.UUID;

@Service
public class FileService {

    @Autowired
    private FileRepository fileRepository;



    public boolean exist(UUID fileId){
        return  fileRepository.existsById(fileId);
    }

    public List<ProjectionFile> getAllFile(){
        return fileRepository.findBy();
    }

    public File getFile(UUID fileId){
        return fileRepository.findById(fileId).orElse(null);

    }

    public File addFile(MultipartFile uploadedFile){
        try {
            File file = new File();
            file.contenttype = uploadedFile.getContentType();
            file.data = uploadedFile.getBytes();
            fileRepository.save(file);
            return file;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public void deleteFile(UUID fileId){
        fileRepository.deleteById(fileId);
    }

    public void deleteAllFile(){
        fileRepository.deleteAll();
    }
}
