package com.example.animeapi.repositories;

import com.example.animeapi.domains.models.File;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.UUID;

public interface FileRepository extends JpaRepository<File, UUID> {

    @Query("select fileid, contenttype FROM File")
    List<String> getFiles(); //TODO: Ask to Professor

}
