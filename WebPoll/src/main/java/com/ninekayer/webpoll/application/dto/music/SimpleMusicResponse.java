package com.ninekayer.webpoll.application.dto.music;

import com.ninekayer.webpoll.application.dto.genre.GenreResponse;

public class SimpleMusicResponse{

    private int id;
    private String name;
    private GenreResponse genre;

    public SimpleMusicResponse() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public GenreResponse getGenre() {
        return genre;
    }

    public void setGenre(GenreResponse genre) {
        this.genre = genre;
    }
}
