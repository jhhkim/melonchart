package com.example.melon.service;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

import com.example.melon.domain.playlist.Playlist;
import com.example.melon.domain.playlist.PlaylistRepository;
import com.example.melon.dto.PlaylistListResponseDto;
import com.example.melon.dto.PlaylistSaveRequestDto;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class PlaylistService {
    private final PlaylistRepository playlistRepository;
    
    // 데이터 넣기
    @Transactional
    public Long save(PlaylistSaveRequestDto requestDto) {
        return playlistRepository.save(requestDto.toEntity()).getId();
    }

    // 전체 데이터 불러오기
    @Transactional(readOnly = true)
    public List<PlaylistListResponseDto> findAll() {
        return playlistRepository.findAll().stream()
        .map(PlaylistListResponseDto::new)
        .collect(Collectors.toList());
    }

    // 데이터 수정
    @Transactional
    public Long update(Long id, PlaylistSaveRequestDto requestDto) {
        Playlist playlist = playlistRepository.findById(id)
            .orElseThrow(()-> new IllegalArgumentException("수정할 노래가 없다." + id));
        playlist.update(requestDto.getSong(), requestDto.getSongLink());
        return id;
    }

    // 데이터 삭제
    @Transactional
    public void delete(Long id) {
        Playlist playlist = playlistRepository.findById(id)
            .orElseThrow(()-> new IllegalArgumentException("삭제할 데이터가 없다." + id));
        playlistRepository.delete(playlist);
    }

    // 전체 데이터를 불러와서 무작위의 값 하나만 리턴
    @Transactional(readOnly = true)
    public PlaylistListResponseDto findRndOne() {
        List<PlaylistListResponseDto> list = playlistRepository.findAll().stream()
        .map(PlaylistListResponseDto::new)
        .collect(Collectors.toList());
        
        Random rnd = new Random();
        PlaylistListResponseDto dto = list.get(rnd.nextInt(list.size()));
        return dto;
    }

}
