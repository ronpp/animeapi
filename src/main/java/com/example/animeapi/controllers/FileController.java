package com.example.animeapi.controllers;

import com.example.animeapi.domains.dto.DisplayMessage;
import com.example.animeapi.domains.dto.FileResult;
import com.example.animeapi.domains.dto.ListResult;
import com.example.animeapi.domains.models.File;
import com.example.animeapi.domains.models.User;
import com.example.animeapi.repositories.FileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/files")
public class FileController {

    @Autowired
    private FileRepository fileRepository;

    @GetMapping(path = "/")
    public ResponseEntity<?> getAllFile() {
        List<File> fileList = fileRepository.findAll();
        if (fileList.size() != 0 ) {
            List<FileResult> fileResults = new ArrayList<>();
            for (File file : fileList ) {
                fileResults.add(new FileResult(file.fileid, file.contenttype));
            }
            return ResponseEntity.ok().body(ListResult.list(fileResults));
        }
        return ResponseEntity.ok().body(ListResult.list(new ArrayList<>()));
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<?> getFile(@PathVariable UUID id){
        File file = fileRepository.findById(id).orElse(null);
        if(file != null)
            return ResponseEntity.ok().contentType(MediaType.valueOf(file.contenttype))
                    .contentLength(file.data.length)
                    .body(file.data);
        String erroMessage = String.format("No s'ha trobat l'arxiu amd id '%s'", id);
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(DisplayMessage.message(erroMessage));
    }

    @PostMapping(path = "/")
    public ResponseEntity<?> addFile(@RequestParam("file") MultipartFile uploadedFile){
        try {
            File file = new File();
            file.contenttype = uploadedFile.getContentType();
            file.data = uploadedFile.getBytes();
            fileRepository.save(file);
            FileResult fileResult = FileResult.file(file.fileid, file.contenttype);
            return ResponseEntity.ok().body(fileResult);
        }catch (Exception e){
            e.printStackTrace();
            return ResponseEntity.internalServerError().build();
        }
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<?> deleteUser(@PathVariable UUID id){
        File file = fileRepository.findById(id).orElse(null);
        if(file != null){
            fileRepository.deleteById(id);
            String message = String.format("S'ha eliminat l'arxiu amd id '%s'" ,id);
            return ResponseEntity.ok().body(DisplayMessage.message(message));
        }
        String errorMessage = String.format("No s'ha trobat l'arxiu amd id %s", id);
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(DisplayMessage.message(errorMessage));
    }

    @DeleteMapping(path = "/")
    public ResponseEntity<?> deleteAllUser(){
        fileRepository.deleteAll();
        return ResponseEntity.ok().body("");
    }
}