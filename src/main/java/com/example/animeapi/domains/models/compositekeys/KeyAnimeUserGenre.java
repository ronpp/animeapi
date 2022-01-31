package com.example.animeapi.domains.models.compositekeys;

import java.io.Serializable;
import java.util.UUID;

public class KeyAnimeUserGenre implements Serializable {

    public UUID animeid;
    public UUID userid;
    public UUID genreid;
}
