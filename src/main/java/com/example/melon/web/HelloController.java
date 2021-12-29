package com.example.melon.web;

import java.util.List;

import com.example.melon.dto.MusicInfoDto;
import com.example.melon.service.MelonService;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
public class HelloController {
    private final MelonService melonService;

    @GetMapping("/api/v1/melon")
    public List<MusicInfoDto> melon()
    {
        return melonService.findMusicList();
    }
}
