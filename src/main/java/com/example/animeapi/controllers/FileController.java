package com.example.animeapi.controllers;

import com.example.animeapi.domains.dto.DisplayMessage;
import com.example.animeapi.domains.dto.FileResult;
import com.example.animeapi.domains.dto.ListResult;
import com.example.animeapi.domains.models.File;
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
import java.util.stream.Collectors;

@RestController
@RequestMapping("/files")
public class FileController {

    @Autowired
    private FileRepository fileRepository;

    @GetMapping(path = "/")
    public ResponseEntity<?> getAllFile() {
        List<FileResult> fileList = fileRepository.getFiles();
//                .stream()
//                .map(FileResult::file)  // Same as (file -> FileResult.file(file))
//                .collect(Collectors.toList());
            return ResponseEntity.ok().body(ListResult.list(fileList));

    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<?> getFile(@PathVariable UUID id) {
        File file = fileRepository.findById(id).orElse(null);
        if (file != null)
            return ResponseEntity.ok().contentType(MediaType.valueOf(file.contenttype))
                    .contentLength(file.data.length)
                    .body(file.data);

        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(DisplayMessage.message(String.format("No s'ha trobat l'arxiu amd id '%s'", id)));
    }

    @PostMapping(path = "/")
    public ResponseEntity<?> addFile(@RequestParam("file") MultipartFile uploadedFile) {
        try {
            File file = new File();
            file.contenttype = uploadedFile.getContentType();
            file.data = uploadedFile.getBytes();
            fileRepository.save(file);
            FileResult fileResult = FileResult.file(file);
            return ResponseEntity.ok().body(fileResult);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.internalServerError().build();
        }
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<?> deleteUser(@PathVariable UUID id) {
        File file = fileRepository.findById(id).orElse(null);
        if (file != null) {
            fileRepository.deleteById(id);
            return ResponseEntity.ok()
                    .body(DisplayMessage.message(String.format("S'ha eliminat l'arxiu amd id '%s'", id)));
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(DisplayMessage.message(String.format("No s'ha trobat l'arxiu amd id %s", id)));
    }

    @DeleteMapping(path = "/")
    public ResponseEntity<?> deleteAllUser() {
        fileRepository.deleteAll();
        return ResponseEntity.ok().body("");
    }
}