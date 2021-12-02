package com.example.animeapi.domains.models;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.Set;
import java.util.UUID;

@Entity
@Table(name = "genre")
public class Genre {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public UUID genreid;
    public String label;

    @ManyToMany(mappedBy = "genres")
    @JsonIgnoreProperties("genres")
    public Set<Anime>animes;


}
