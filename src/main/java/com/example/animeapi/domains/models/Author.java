package com.example.animeapi.domains.models;


import javax.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "Author")
public class Author {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public UUID id;
    public String name;
    public String image;


}
