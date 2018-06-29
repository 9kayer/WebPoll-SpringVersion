package com.ninekayer.webpoll.domain.service;

import com.ninekayer.webpoll.domain.model.Music;
import com.ninekayer.webpoll.infra.repository.MusicRepository;
import org.springframework.stereotype.Service;

import java.util.List;

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
        return repo.findById(id)
                    .orElseThrow(RuntimeException::new);
    }
}
