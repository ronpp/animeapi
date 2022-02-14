package com.example.animeapi.domains.models;


import com.example.animeapi.domains.dto.RequestAnimeCreate;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.Set;
import java.util.UUID;

@Entity
@Table(name = "anime")
public class Anime {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public UUID animeid;
    public String name;
    public String description;
    public String type;
    public int year_release;
    public int episodes;
    public String imageurl;

    @ManyToMany
    @JoinTable(name="anime_author", joinColumns = @JoinColumn(name = "animeid"), inverseJoinColumns = @JoinColumn(name = "authorid"))
    @JsonIgnoreProperties("animes")
    public Set<Author> authors;

    @ManyToMany
    @JoinTable(name="anime_genre", joinColumns = @JoinColumn(name = "animeid"), inverseJoinColumns = @JoinColumn(name = "genreid"))
    @JsonIgnoreProperties("animes")
    public Set<Genre> genres;

    @ManyToMany
    @JoinTable(name="favorite", joinColumns = @JoinColumn(name = "animeid"), inverseJoinColumns = @JoinColumn(name = "userid"))
    public Set<User> favoriteby;


    public static Anime fromRequest(RequestAnimeCreate requestAnimeCreate) {
        Anime anime = new Anime();
        anime.name = requestAnimeCreate.name;
        anime.description = requestAnimeCreate.description;
        anime.imageurl = requestAnimeCreate.imageurl;
        anime.type = requestAnimeCreate.type;
        anime.year_release = requestAnimeCreate.year_release;
        return anime;
    }
}
