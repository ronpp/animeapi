package com.example.animeapi.domains.models;

import javax.persistence.*;
import java.util.Set;
import java.util.UUID;

@Entity
@Table(name = "usser")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public UUID userid;
    public String username;
    public String password;
    public String role;
    public boolean enabled;

    @ManyToMany(mappedBy = "favoriteby")
    public Set<Anime> favorites;
}
