package com.company.music.repository;

import com.company.music.model.Song;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SongRepository extends JpaRepository<Song, Long> {
}
