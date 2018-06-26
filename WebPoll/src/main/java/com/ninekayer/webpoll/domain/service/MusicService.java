package com.ninekayer.webpoll.domain.service;

import com.ninekayer.webpoll.domain.model.Music;
import com.ninekayer.webpoll.infra.repository.MusicRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MusicService {

    private MusicRepository repo;

    public MusicService(MusicRepository musicRepository) {
        this.repo = musicRepository;
    }

    public List<Music> getAll(){
        return repo.findAll();
    }

    public Music getById(int id){
        Optional<Music> musicOptional = repo.findById(id);

        if(!musicOptional.isPresent()){
            return null;
        }

        return musicOptional.get();
    }
}
