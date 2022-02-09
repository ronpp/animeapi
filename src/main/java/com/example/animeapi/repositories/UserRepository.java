package com.example.animeapi.repositories;

import com.example.animeapi.domains.models.User;
import com.example.animeapi.domains.models.projections.ProjectionUser;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface UserRepository extends JpaRepository<User, UUID> {
    User findByUsername(String username);
    List<ProjectionUser>findBy();
    <T> T findByUserid(UUID id, Class<T> type);
}
