package com.ninekayer.webpoll.application.dto.artist;

public class SimpleArtistResponse {

    private int id;
    private String name;

    public SimpleArtistResponse() {
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
}