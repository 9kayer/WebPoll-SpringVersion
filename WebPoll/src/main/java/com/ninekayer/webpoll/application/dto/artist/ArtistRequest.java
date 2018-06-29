package com.ninekayer.webpoll.application.dto.artist;

import com.ninekayer.webpoll.application.dto.music.SimpleMusicResponse;

import java.util.List;

public class ArtistRequest {

    private String name;

    public ArtistRequest() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
