package com.ninekayer.webpoll.application.dto.artist;

import com.ninekayer.webpoll.application.dto.music.SimpleMusicResponse;

import java.util.List;

public class ArtistResponse {

    private int id;
    private String name;
    private List<SimpleMusicResponse> musicList;

    public ArtistResponse() {
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

    public List<SimpleMusicResponse> getMusicList() {
        return musicList;
    }

    public void setMusicList(List<SimpleMusicResponse> musicList) {
        this.musicList = musicList;
    }


}
