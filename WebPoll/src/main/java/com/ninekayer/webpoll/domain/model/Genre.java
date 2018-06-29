package com.ninekayer.webpoll.domain.model;

import javax.persistence.*;

@Entity
@Table(name = "GENRE", schema = "dbo")
public class Genre {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "Name")
    private String name;

    protected Genre() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public static class Builder{

        private Genre genre;

        public Builder(){
            genre = new Genre();
        }

        public Builder(Genre genre){
            this.genre = genre;
        }

        public Builder id(int id){
            genre.setId(id);
            return this;
        }

        public Builder name(String name){
            genre.setName(name);
            return this;
        }

        public Genre build() {
            return genre;
        }
    }
}
