package com.example.animeapi.domains.models;

import com.example.animeapi.domains.models.compositekeys.KeyAnimeUser;
import com.example.animeapi.domains.models.compositekeys.KeyRating;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;
import java.util.UUID;

@Entity
@Table(name = "rating")
@IdClass(KeyRating.class)
public class Rating {

    @Id
    public String username;
    @Id
    public String anime;
    public double score;



}
