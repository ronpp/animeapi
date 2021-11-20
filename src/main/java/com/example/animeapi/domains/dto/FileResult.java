package com.example.animeapi.domains.dto;

import java.util.UUID;

public class FileResult {
    public UUID fileid;
    public String contenttype;

    public FileResult(UUID fileid, String contenttype) {
        this.fileid = fileid;
        this.contenttype = contenttype;
    }
    public static FileResult file(UUID fileid, String contenttype){
        return new FileResult(fileid, contenttype);
    }
}
