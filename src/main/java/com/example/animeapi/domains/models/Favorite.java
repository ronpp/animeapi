package com.example.animeapi.domains.models;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.UUID;

@Entity
@Table(name= "favorite")
public class Favorite {
    @Id
    public UUID userid;
    public UUID animeid;

}
