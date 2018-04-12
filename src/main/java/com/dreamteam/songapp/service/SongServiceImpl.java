package com.dreamteam.songapp.service;

import com.dreamteam.songapp.enteties.Song;
import com.dreamteam.songapp.repository.SongRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SongServiceImpl implements SongService {

    @Autowired
    private SongRepository songRepository;

    @Override
    public List<Song> getTop() {
        return songRepository.getTop();
    }

    @Override
    public List<Song> search(String query) {
        return songRepository.search(query);
    }

    @Override
    public Song getSongByName(String name) {
        return songRepository.findByName(name);
    }

    @Override
    public void updateSong(Song song) {
        songRepository.updateSong(song.getName(), song.getDescription(), song.getPerformer(), song.getId());
    }
}
