package com.company.music.controller;

import com.company.music.controller.exception.NotFoundException;
import com.company.music.model.Artist;
import com.company.music.model.Song;
import com.company.music.repository.ArtistRepository;
import com.company.music.repository.SongRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/songs")
public class SongController {

    private final SongRepository songRepository;
    private final ArtistRepository artistRepository;

    @Autowired
    public SongController(SongRepository songRepository, ArtistRepository artistRepository) {
        this.songRepository = songRepository;
        this.artistRepository = artistRepository;
    }

    @GetMapping
    public List<Song> getAllSongs() {
        return songRepository.findAll();
    }

    @GetMapping("/{id}")
    public Song getSongById(@PathVariable Long id) {
        return songRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Song not found with id: " + id));
    }

    @PostMapping
    public Song createSong(@RequestBody Song song) {
        return songRepository.save(song);
    }


    @PutMapping("/{id}")
    public Song updateSong(@PathVariable Long id, @RequestBody Song updatedSong) {
        Song song = songRepository.findById(id).get();

        song.setName(updatedSong.getName());
        song.setYear(updatedSong.getYear());
        song.setDuration(updatedSong.getDuration());
        song.setAlbum(updatedSong.getAlbum());
        song.setNumber(updatedSong.getNumber());

        updatedSong.getName();
        if (song.getArtist().getId() != updatedSong.getArtist().getId()) {
            Artist artist = artistRepository.findById((long)updatedSong.getArtist().getId())
                    .orElseThrow(() -> new NotFoundException("Artist not found with id: " + updatedSong.getArtist().getId()));
            song.setArtist(artist);
        }

        return songRepository.save(song);
    }

    @DeleteMapping("/{id}")
    public void deleteSong(@PathVariable Long id) {
        songRepository.deleteById(id);
    }
}
