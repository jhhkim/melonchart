package com.example.melon.web;

import java.util.List;

import com.example.melon.dto.PlaylistListResponseDto;
import com.example.melon.dto.PlaylistSaveRequestDto;
import com.example.melon.service.PlaylistService;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
public class PlaylistApiController {
    private final PlaylistService playlistService;

    @PostMapping("/api/v1/playlistsave")
    public Long save(@RequestBody PlaylistSaveRequestDto requestDto) {
        return playlistService.save(requestDto);
    }

    @GetMapping("/api/v1/playlistall")
    public List<PlaylistListResponseDto> playlistFindAll() {
        return playlistService.findAll();
    }

    @PutMapping("/api/v1/playlist/{id}")
    public Long update(@PathVariable Long id, @RequestBody PlaylistSaveRequestDto requestDto) {
        return playlistService.update(id, requestDto);
    }

    @DeleteMapping("/api/v1/playlist/{id}")
    public Long delete(@PathVariable Long id) {
        playlistService.delete(id);
        return id;
    }

    @GetMapping("/api/v1/rndplaylist")
    public PlaylistListResponseDto playlistOne() {
        return playlistService.findRndOne();
    }
    
}
