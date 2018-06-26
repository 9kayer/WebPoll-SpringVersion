package com.ninekayer.webpoll.infra.repository;

import com.ninekayer.webpoll.domain.model.Artist;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ArtistRepository extends JpaRepository<Artist,Integer> {
}
