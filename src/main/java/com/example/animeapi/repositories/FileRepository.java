package com.example.animeapi.repositories;

import com.example.animeapi.domains.dto.FileResult;
import com.example.animeapi.domains.models.File;
import com.example.animeapi.domains.models.projections.ProjectionFile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.UUID;

public interface FileRepository extends JpaRepository<File, UUID> {

    List<ProjectionFile> findBy();


}
