package com.dreamteam.songapp.dto;

import com.dreamteam.songapp.enteties.Song;

import javax.validation.constraints.NotNull;
import java.util.List;

public class PlaylistDto {
    @NotNull
    private String name;
    private List<Song> songList;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Song> getSongList() {
        return songList;
    }

    public void setSongList(List<Song> songList) {
        this.songList = songList;
    }
}
