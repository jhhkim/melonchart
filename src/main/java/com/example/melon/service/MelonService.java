package com.example.melon.service;

import java.util.List;

import com.example.melon.dto.MusicInfoDto;
import com.example.melon.utils.Melon;

import org.springframework.stereotype.Service;

@Service
public class MelonService 
    {

        public List<MusicInfoDto> findMusicList()
        {
            return Melon.getMusicList();
        }
        
    }
    

