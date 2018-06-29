package com.ninekayer.webpoll.application.controller;

import com.ninekayer.webpoll.application.dto.artist.ArtistRequest;
import com.ninekayer.webpoll.application.dto.artist.ArtistResponse;
import com.ninekayer.webpoll.domain.model.Artist;
import com.ninekayer.webpoll.domain.service.ArtistService;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
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

    @PostMapping
    public ResponseEntity<ArtistResponse> create(@Valid @RequestBody ArtistRequest artistRequest){
        Artist artist = artistService.create(mapper.map(artistRequest, Artist.class));

        return new ResponseEntity<>(mapper.map( artistService.create(artist), ArtistResponse.class), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ArtistResponse> update(@PathVariable String id,
                                                 @Valid @RequestBody ArtistRequest artistRequest){
        Artist artist = artistService.update( Integer.parseInt(id),
                                            mapper.map( artistRequest, Artist.class) );

        return new ResponseEntity<>(mapper.map( artist, ArtistResponse.class), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteById(@PathVariable String id){
        artistService.deleteById(Integer.parseInt(id));
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
