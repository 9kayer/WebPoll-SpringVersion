package com.ninekayer.webpoll.domain.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "ARTIST", schema = "dbo")
public class Artist {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "Name")
    private String name;

    @OneToMany(mappedBy = "artist", fetch = FetchType.EAGER)
    private List<Music> musicList = new ArrayList<>();

    protected Artist() {
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

    public List<Music> getMusicList() {
        return musicList;
    }

    public void setMusicList(List<Music> musicList) {
        this.musicList = musicList;
    }
    
    public static class Builder{
        
        private final Artist artist;
        
        public Builder(){
            this.artist = new Artist();
        }

        public Builder(Artist artist){
            this.artist = artist;
        }

        public Builder id(int id){
            artist.setId(id);
            return this;
        }

        public Builder name(String name){
            artist.setName(name);
            return this;
        }

        public Builder musicList(List<Music> musicList){
            artist.setMusicList(musicList);
            return this;
        }

        public Artist build(){
            return artist;
        }
    }
}
