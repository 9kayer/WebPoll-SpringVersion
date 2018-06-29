package com.ninekayer.webpoll.domain.service;

import com.ninekayer.webpoll.domain.model.Artist;
import com.ninekayer.webpoll.infra.repository.ArtistRepository;

import org.springframework.stereotype.Service;
import java.util.List;

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
        return repo.findById(id)
                    .orElseThrow(RuntimeException::new);
    }

    public Artist create(Artist artist) {
        return repo.save(artist);
    }

    public Artist update(int id, Artist artist){
        return repo.findById(id)
                    .map(art -> new Artist.Builder(art)
                                        .name(artist.getName())
                                        .build())
                    .map(art -> repo.save(art))
                    .orElseThrow(RuntimeException::new);
    }

    public void deleteById(int id) {
        repo.deleteById(id);
    }
}
