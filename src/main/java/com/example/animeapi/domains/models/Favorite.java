package com.example.animeapi.domains.models;

import com.example.animeapi.domains.models.compositekeys.KeyAnimeUser;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;
import java.util.UUID;

@Entity
@Table(name= "favorite")
@IdClass(KeyAnimeUser.class)
public class Favorite {
    @Id
    public UUID userid;
    @Id
    public UUID animeid;

}
