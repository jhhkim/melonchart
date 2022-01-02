package com.example.melon.dto;

import com.example.melon.domain.playlist.Playlist;

import lombok.Getter;

@Getter
public class PlaylistListResponseDto {
    private Long id;
    private String song;
    private String songLink;

    public PlaylistListResponseDto(Playlist entity) {
        this.id = entity.getId();
        this.song = entity.getSong();
        this.songLink = entity.getSongLink();
    }
}
