package com.ninekayer.webpoll.domain.service;

import com.ninekayer.webpoll.domain.model.Artist;
import com.ninekayer.webpoll.infra.repository.ArtistRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ArtistService {

    private ArtistRepository repo;

    public ArtistService(ArtistRepository artistRepository) {
        this.repo = artistRepository;
    }

    public List<Artist> getAll(){
        return repo.findAll();
    }

    public Artist getById(int id){
        return repo.findById(id).orElse(null);
    }
}
