package com.example.animeapi.domains.dto;

import java.util.List;

public class ListResult {
    public List<?> result;

    public ListResult(List<?> result) {
        this.result = result;
    }

    public static ListResult list(List<?> result){
        return new ListResult(result);
    }
}
