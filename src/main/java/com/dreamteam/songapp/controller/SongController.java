package com.dreamteam.songapp.controller;

import com.dreamteam.songapp.enteties.Song;
import com.dreamteam.songapp.repository.SongRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;


@Controller
public class SongController {

    @Autowired
    private SongRepository songRepository;

    @RequestMapping(value = "/show", method = RequestMethod.GET)
    public String viewSong(Model model){
        List<Song> songs = songRepository.findAll();
        model.addAttribute("songs", songs);
        return "show.html";
    }

    @RequestMapping(value = "/top", method = RequestMethod.GET)
    public String viewTop(Model model){
        List<Song> songs = songRepository.getTop();
        model.addAttribute("songs", songs);
        return "show.html";
    }

    @RequestMapping(value ="/", method = RequestMethod.GET)
    public String search(@RequestParam(value = "search", required = false) String query, Model model){
        List<Song> songs = songRepository.search('%'+query+'%');
        model.addAttribute("search", songs);
        return "index.html";
    }

}
