package com.example.melon.web;

import com.example.melon.service.PlaylistService;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Controller
public class PlaylistController {
    private final PlaylistService playlistService;

   @GetMapping("/playlist")
   public String playlist(Model model) {
       model.addAttribute("playlist", playlistService.findAll());
       return "playlist";
   }

   @GetMapping("/rndplaylist")
   public String rndplaylist() {
       return "rndplaylist";
   }    
}

