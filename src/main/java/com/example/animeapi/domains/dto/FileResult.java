package com.example.animeapi.domains.dto;

import com.example.animeapi.domains.models.File;

import java.util.UUID;

public class FileResult {
    public UUID fileid;
    public String contenttype;

    public FileResult(File file) {
        this.fileid = file.fileid;
        this.contenttype = file.contenttype;
    }

    public static FileResult file(File file) {
        return new FileResult(file);
    }
}
