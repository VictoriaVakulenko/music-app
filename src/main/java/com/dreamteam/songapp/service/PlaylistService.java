package com.dreamteam.songapp.service;

import com.dreamteam.songapp.enteties.Playlist;

import java.util.List;

public interface PlaylistService {

    void addPlaylist(String name, Long userId);
    List<Playlist> getAllUserPlaylists(Long userId);

}
