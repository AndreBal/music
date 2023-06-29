package com.company.music.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter @ToString
@Entity
@Table(name="songs")
public class Song {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private int id;

    @Column(name = "name")
    private String name;
    @Column(name = "year")
    private int year;
    @Column(name = "duration")
    private int duration;
    @Column(name = "album")
    private String album;
    @Column(name="number")
    private int number;
    @JsonBackReference
    @ManyToOne
    @JoinColumn(name="artists_id")
    private Artist artist;

}
