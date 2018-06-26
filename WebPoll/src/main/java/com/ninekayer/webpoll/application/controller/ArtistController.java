package com.ninekayer.webpoll.application.controller;

import com.ninekayer.webpoll.application.dto.artist.ArtistResponse;
import com.ninekayer.webpoll.domain.service.ArtistService;
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
@RequestMapping("api/artists")
public class ArtistController {

    private ArtistService artistService;
    private ModelMapper mapper;

    public ArtistController(ArtistService artistService, ModelMapper mapper) {
        this.artistService = artistService;
        this.mapper = mapper;
    }

    @GetMapping
    public ResponseEntity<List<ArtistResponse>> getAll(){
        List<ArtistResponse> artists = artistService.getAll().stream()
                                            .map(artist -> mapper.map(artist, ArtistResponse.class))
                                            .collect(Collectors.toList());

        return new ResponseEntity<>(artists, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ArtistResponse> getById(@PathVariable String id){
        return new ResponseEntity<>(mapper.map( artistService.getById(Integer.parseInt(id)),
                                                ArtistResponse.class),
                                    HttpStatus.OK);
    }
}
