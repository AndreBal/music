package com.company.music.controller;

import com.company.music.controller.exception.NotFoundException;
import com.company.music.model.Artist;
import com.company.music.repository.ArtistRepository;
import com.company.music.repository.SongRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/artists")
public class ArtistController {

    private final ArtistRepository artistRepository;
    private final SongRepository songRepository;

    @Autowired
    public ArtistController(SongRepository songRepository, ArtistRepository artistRepository) {
        this.songRepository = songRepository;
        this.artistRepository = artistRepository;
    }

    @GetMapping
    public List<Artist> getAllArtists() {
        return artistRepository.findAll();
    }

    @GetMapping("/{id}")
    public Artist getArtistById(@PathVariable Long id) {
        return artistRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Artist not found with id: " + id));

    }

    @PostMapping
    public Artist createArtist(@RequestBody Artist artist) {
        return artistRepository.save(artist);
    }


    @PutMapping("/{id}")
    public Artist updateArtist(@PathVariable Long id, @RequestBody Artist updatedArtist) {
        Artist artist = artistRepository.findById(id).get();

        artist.setName(updatedArtist.getName());
        artist.setActive(updatedArtist.isActive());
        artist.setCountry(updatedArtist.getCountry());
        artist.setAlbumsNum(updatedArtist.getAlbumsNum());
        artist.setGenre(updatedArtist.getGenre());

        return artistRepository.save(artist);
    }

    @DeleteMapping("/{id}")
    public void deleteArtist(@PathVariable Long id) {
        artistRepository.deleteById(id);
    }
}
