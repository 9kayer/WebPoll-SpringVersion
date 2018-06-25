package com.ninekayer.webpoll.application.dto.genre;

public class GenreRequest {

    private String id;
    private String name;

    public GenreRequest() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
