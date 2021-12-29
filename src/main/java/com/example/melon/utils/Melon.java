package com.example.melon.utils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.example.melon.dto.MusicInfoDto;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class Melon 
{
    public static List<MusicInfoDto> getMusicList()
    {
        System.out.println("melon top 100");
        List<MusicInfoDto> list = new ArrayList<MusicInfoDto>();
        String URL = "https://www.melon.com/chart/index.htm";


        try
        {
            Document doc = Jsoup.connect(URL).get();

            Elements tit = doc.select("div.ellipsis.rank01 > span > a");
            Elements artist = doc.select("div.ellipsis.rank02 > span");

            int rank = 0;

            //임시리스트
            List<String> tmpList = new ArrayList<>();
            for(Element e: artist)
            {
                tmpList.add(e.text());
            }
            for(Element e : tit)
            {
                MusicInfoDto dto = new MusicInfoDto();
                dto.setRank(rank+1);
                dto.setTitle(e.text());
                dto.setArtist((tmpList.get(rank++)));
                list.add(dto);
            }
            
        } catch (IOException e1)
            {
                e1.printStackTrace();
            }
            return list;
    }
}
