package com.dreamteam.songapp.enteties;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name="playlist")
public class Playlist {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name = "playlistName")
    private String name;
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "playlist_songs",
            joinColumns = @JoinColumn
                    (name = "playlist_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn
                    (name = "song_id", referencedColumnName = "id", table = "songs"))
    private Collection<Song> songs;
    @Column(name = "user_id")
    private Long userId;

    public Playlist(){}

    public Playlist(String name){this.name = name;}

    public Playlist(Collection<Song> songs) {
        this.songs = songs;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Collection<Song> getSongs() {
        return songs;
    }

    public void setSongs(Collection<Song> songs) {
        this.songs = songs;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }
}
