package com.ninekayer.webpoll.domain.service;

import com.ninekayer.webpoll.domain.model.Genre;
import com.ninekayer.webpoll.infra.repository.GenreRepository;

import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class GenreService {

    private GenreRepository repo;

    public GenreService(GenreRepository repo) {
        this.repo = repo;
    }

    public List<Genre> getAll(){
        return repo.findAll();
    }

    public Genre getById(int id){
        return repo.findById(id)
                    .orElseThrow(RuntimeException::new);
    }

    public Genre create(Genre newGenre){
        return repo.save(newGenre);
    }

    public Genre update(int id, Genre updateGenre){
        return repo.findById(id)
                    .map(genre -> new Genre.Builder(genre)
                                            .name(updateGenre.getName())
                                            .build())
                    .map(genre -> repo.save(genre))
                    .orElseThrow(RuntimeException::new);
    }

    public void deleteById(int id){
        repo.deleteById(id);
    }
}
