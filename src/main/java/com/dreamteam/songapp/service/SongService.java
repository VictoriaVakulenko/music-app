package com.dreamteam.songapp.service;

import com.dreamteam.songapp.enteties.Song;

import java.util.List;

public interface SongService {
    List<Song> getTop();
    List<Song> search(String query);
    Song getSongByName(String name);
    void updateSong(Song song);
}
