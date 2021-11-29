package com.example.animeapi.repositories;

import com.example.animeapi.domains.models.Author;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface AuthorRepository extends JpaRepository<Author, UUID> {
}
