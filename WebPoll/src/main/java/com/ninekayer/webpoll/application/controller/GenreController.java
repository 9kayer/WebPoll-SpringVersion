package com.ninekayer.webpoll.application.controller;

import com.ninekayer.webpoll.application.dto.genre.GenreRequest;
import com.ninekayer.webpoll.application.dto.genre.GenreResponse;
import com.ninekayer.webpoll.domain.model.Genre;
import com.ninekayer.webpoll.domain.service.GenreService;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("api/genres")
public class GenreController {

    private GenreService genreService;
    private ModelMapper mapper;

    public GenreController(GenreService genreService, ModelMapper mapper) {
        this.genreService = genreService;
        this.mapper = mapper;
    }

    @GetMapping()
    public ResponseEntity<List<GenreResponse>> getAll(){
        List<GenreResponse> genres = genreService.getAll()
                                        .stream()
                                        .map(genre -> mapper.map(genre, GenreResponse.class))
                                        .collect(Collectors.toList());
        return new ResponseEntity<>(genres, HttpStatus.OK);
    }

    @GetMapping("{id}")
    public ResponseEntity<GenreResponse> getById(@PathVariable String id){
        return new ResponseEntity<>(mapper.map(genreService.getById(Integer.parseInt(id)),
                                                            GenreResponse.class ),
                                                HttpStatus.OK);
    }


    @PostMapping()
    public ResponseEntity<GenreResponse> create(@Valid @RequestBody GenreRequest genreRequest){

        Genre newGenre = genreService.create(mapper.map(genreRequest, Genre.class));

        return new ResponseEntity<>(mapper.map(newGenre, GenreResponse.class),
                HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<GenreResponse> update(@Valid @RequestBody GenreRequest genreRequest,
                                                @PathVariable String id){

        Genre updatedGenre = genreService.update(Integer.parseInt(id), mapper.map(genreRequest, Genre.class));

        return new ResponseEntity<>(mapper.map(updatedGenre, GenreResponse.class),
                HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteById(@PathVariable String id){
        genreService.deleteById(Integer.parseInt(id));
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
