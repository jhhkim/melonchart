package com.example.melon.domain.playlist;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
@Entity
public class Playlist {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 50, nullable = false)
    private String song;

    @Column(length = 50, nullable = false)
    private String artist;

    @Column(length = 500, nullable = false)
    private String songLink;

    @Builder
    public Playlist(String song, String artist, String songLink) {
        this.song = song;
        this.artist = artist;
        this.songLink = songLink;
    }

    public void update(String song, String artist, String songLink) {
        this.song = song;
        this.artist = artist;
        this.songLink = songLink;
    }

}
