package com.dreamteam.songapp.enteties;

import javax.persistence.*;

@Entity
@Table(name = "songs")
public class Song {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name = "song")
    public String name;
    @Column(name = "description")
    public String description;
    @Column(name = "performer")
    public String performer;

    public Song(){}

    public Song(String name, String performer,  String description) {
        this.name = name;
        this.description = description;
        this.performer = performer;
    }

    public static Song createSong(String name, String performer, String description){
        return new Song(name, performer, description);
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPerformer() {
        return performer;
    }

    public void setPerformer(String performer) {
        this.performer = performer;
    }

}
