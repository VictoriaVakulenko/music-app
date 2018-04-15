package com.dreamteam.songapp.repository;

import com.dreamteam.songapp.enteties.Song;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
public interface SongRepository extends JpaRepository<Song, Long> {

    @Query("select s from Song s where  s.description = 'Top 20'")
    List<Song> getTop();

    @Query("select s from Song s where s.name like :query")
    List<Song> search(@Param("query") String query);

    @Query("select  s from Song s where  s.name =:name")
    Song findByName(@Param("name") String name);


    @Modifying(clearAutomatically = true)
    @Query("update Song  s SET s.name =:name, s.description =:description, s.performer =:performer where s.id =:id")
    void updateSong(@Param("name") String name, @Param("description") String description,
                    @Param("performer") String performer, @Param("id") Long id);

}
