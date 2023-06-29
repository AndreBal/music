package com.company.music.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Getter @Setter @ToString
@Entity
@Table(name="artists")
public class Artist {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private int id;

    @Column(name = "name")
    private String name;
    @Column(name = "albums_num")
    private int albumsNum;
    @Column(name = "country")
    private String country;
    @Column(name="genre")
    private String genre;
    @Column(name="is_active")
    private boolean isActive;
    @JsonManagedReference
    @OneToMany( mappedBy = "artist") //cascade = CascadeType.ALL,
    private List<Song> songs;

}
