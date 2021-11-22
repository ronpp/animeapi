package com.example.animeapi.repositories;

import com.example.animeapi.domains.dto.FileResult;
import com.example.animeapi.domains.models.File;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.UUID;

public interface FileRepository extends JpaRepository<File, UUID> {


    // Source : https://javamana.com/2020/11/202011241219304403.html
    @Query(value = "select new com.example.animeapi.domains.dto.FileResult(fileid, contenttype) FROM File")
    List<FileResult> getFiles();


}
