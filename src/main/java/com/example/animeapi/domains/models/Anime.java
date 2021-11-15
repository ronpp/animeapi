package com.example.animeapi.domains.models;


import javax.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "anime")
public class Anime {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public UUID id;
    public String name;
    public String descripcion;
    public String type;
    public int year_release;
    public String image;


}
