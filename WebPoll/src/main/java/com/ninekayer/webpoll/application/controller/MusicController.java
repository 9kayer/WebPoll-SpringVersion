package com.ninekayer.webpoll.application.controller;

import com.ninekayer.webpoll.application.dto.music.MusicResponse;
import com.ninekayer.webpoll.domain.service.MusicService;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("api/musics")
public class MusicController {

    private MusicService musicService;
    private ModelMapper mapper;

    public MusicController(MusicService musicService, ModelMapper mapper) {
        this.musicService = musicService;
        this.mapper = mapper;
    }

    @GetMapping
    public ResponseEntity<List<MusicResponse>> getAll(){
        List<MusicResponse> musicList = musicService.getAll().stream()
                                                    .map(music -> mapper.map(music, MusicResponse.class))
                                                    .collect(Collectors.toList());

        return new ResponseEntity<>(musicList, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<MusicResponse> getById(@PathVariable String id){
        return new ResponseEntity<>(mapper.map( musicService.getById(Integer.parseInt(id)),
                                                MusicResponse.class),
                                    HttpStatus.OK);
    }
}
