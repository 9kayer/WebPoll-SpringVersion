package com.ninekayer.webpoll.infra.repository;

import com.ninekayer.webpoll.domain.model.Genre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface GenreRepository  extends JpaRepository<Genre,Integer> {
}
