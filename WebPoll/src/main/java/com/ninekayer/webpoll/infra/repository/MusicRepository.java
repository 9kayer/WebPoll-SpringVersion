package com.ninekayer.webpoll.infra.repository;

import com.ninekayer.webpoll.domain.model.Music;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MusicRepository extends JpaRepository<Music, Integer> {
}
