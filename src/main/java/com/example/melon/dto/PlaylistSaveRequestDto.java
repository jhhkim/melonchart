package com.example.melon.dto;

import com.example.melon.domain.playlist.Playlist;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class PlaylistSaveRequestDto {
    private String song;
    private String artist;
    private String songLink;

    @Builder
    public PlaylistSaveRequestDto(String song, String artist, String songLink) {
        this.song = song;
        this.artist = artist;
        this.songLink = songLink;
    }

    public Playlist toEntity() {
        return Playlist.builder()
            .song(song)
            .artist(artist)
            .songLink(songLink)
            .build();
    }
}
