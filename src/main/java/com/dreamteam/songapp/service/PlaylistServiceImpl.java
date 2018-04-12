package com.dreamteam.songapp.service;

import com.dreamteam.songapp.enteties.Playlist;
import com.dreamteam.songapp.repository.PlaylistRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlaylistServiceImpl implements PlaylistService {

    @Autowired
    private PlaylistRepository playlistRepository;

    @Override
    public void addPlaylist(String name, Long userId) {
        Playlist playlist = new Playlist();
        playlist.setName(name);
        playlist.setUserId(userId);
        playlistRepository.save(playlist);
    }

    @Override
    public List<Playlist> getAllUserPlaylists(Long userId) {
        return playlistRepository.getAllById(userId);
    }
}
