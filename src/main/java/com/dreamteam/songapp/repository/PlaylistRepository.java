package com.dreamteam.songapp.repository;

import com.dreamteam.songapp.enteties.Playlist;
import org.hibernate.annotations.NamedNativeQueries;
import org.hibernate.annotations.NamedNativeQuery;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PlaylistRepository extends JpaRepository<Playlist, Long> {

    @Query("Select p from Playlist p where p.userId =:userId")
    List<Playlist> getAllById(@Param("userId") Long userId);

    @Query(nativeQuery = true, value="Select COUNT(*) from playlist where userId=:userId")
    int getPlaylistNumber(@Param("userId") Long userId);
}
