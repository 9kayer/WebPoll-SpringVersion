package com.ninekayer.webpoll.application.dto.music;

import com.ninekayer.webpoll.application.dto.artist.SimpleArtistResponse;
import com.ninekayer.webpoll.application.dto.genre.GenreResponse;

public class MusicResponse {

    private int id;
    private String name;
    private GenreResponse genre;
    private SimpleArtistResponse artist;

    public MusicResponse() {
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

    public SimpleArtistResponse getArtist() {
        return artist;
    }

    public void setArtist(SimpleArtistResponse artist) {
        this.artist = artist;
    }

}
