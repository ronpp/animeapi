package com.example.animeapi.controllers;

import com.example.animeapi.domains.dto.DisplayMessage;
import com.example.animeapi.domains.dto.FileResult;
import com.example.animeapi.domains.dto.ListResult;
import com.example.animeapi.domains.models.File;
import com.example.animeapi.repositories.FileRepository;
import com.example.animeapi.services.FileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;


import java.util.UUID;

@RestController
@RequestMapping("/files")
public class FileController {

    @Autowired
    private FileService fileService;



    @GetMapping("/")
    public ResponseEntity<?> getAllFile() {
            return ResponseEntity.ok().body(ListResult.list(fileService.getAllFile()));
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getFile(@PathVariable UUID id) {
        if (fileService.exist(id)){
            File file = fileService.getFile(id);
            return ResponseEntity.ok().contentType(MediaType.valueOf(file.contenttype))
                    .contentLength(file.data.length)
                    .body(file.data);
        }

        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(DisplayMessage.message(String.format("No s'ha trobat l'arxiu amd id '%s'", id)));
    }

    @PostMapping("/")
    public ResponseEntity<?> addFile(@RequestParam("file") MultipartFile uploadedFile) {

        if (fileService.addFile(uploadedFile) != null){
            return ResponseEntity.ok().body(FileResult.file(fileService.addFile(uploadedFile)));
        }
        return ResponseEntity.internalServerError().build();

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteFile(@PathVariable UUID id) {
        if (fileService.exist(id)) {
            fileService.deleteFile(id);
            return ResponseEntity.ok()
                    .body(DisplayMessage.message(String.format("S'ha eliminat l'arxiu amd id '%s'", id)));
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(DisplayMessage.message(String.format("No s'ha trobat l'arxiu amd id %s", id)));
    }

    @DeleteMapping("/")
    public ResponseEntity<?> deleteAllFile() {
        fileService.deleteAllFile();
        return ResponseEntity.ok().build();
    }
}