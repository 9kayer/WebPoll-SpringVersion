package com.ninekayer.webpoll.domain.service;

import com.ninekayer.webpoll.domain.model.Genre;
import com.ninekayer.webpoll.infra.repository.GenreRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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

        Optional<Genre> genreOptional = repo.findById(id);

        if (genreOptional.isPresent()){
            return genreOptional.get();
        }

        return null;
    }

    public Genre create(Genre newGenre){
        return repo.save(newGenre);
    }

    public Genre update(int id, Genre updateGenre){

        if(repo.findById(id).isPresent()){
            return repo.save(updateGenre);
        }

        return null;
    }

    public void deleteById(int id){
        repo.deleteById(id);
    }
}
