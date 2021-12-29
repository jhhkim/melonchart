package com.example.melon.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {
    @GetMapping("/")
    public String index()
    {
        return "index";
    }

    @GetMapping("/hello")
    public String hello()
    {
        return "hello";
    }

    @GetMapping("/melon")
    public String melon()
    {
        return "melon";
    }
}
