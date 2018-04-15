package com.dreamteam.songapp;

import com.dreamteam.songapp.enteties.Playlist;
import com.dreamteam.songapp.enteties.Song;
import com.dreamteam.songapp.repository.PlaylistRepository;
import com.dreamteam.songapp.repository.SongRepository;
import com.dreamteam.songapp.service.SongService;
import com.dreamteam.songapp.service.SongServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.core.IsCollectionContaining.hasItem;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class SongAppMockitoTests {
    @Spy
    private SongServiceImpl songServiceSpy;
    @Mock
    private SongRepository songRepository;
    @Mock
    private PlaylistRepository playlistRepository;
    @Mock
    private Song song;
    @Mock
    private List<Song> songs;

    @Test(expected = NullPointerException.class)
    public void shouldThrowNullPointerException_whenGetSongWithoutContext() throws Exception{
        Song retrievedSong = songServiceSpy.getSongByName("test");
        assertThat(retrievedSong, is(equalTo(song)));
    }

    @Test
    public void shouldVerifyThatSearchCalled(){
        Mockito.doReturn(songs).when(songServiceSpy).search("Perfect");
        List<Song> retrievedSong = songServiceSpy.search("Perfect");
        Mockito.verify(songServiceSpy).search("Perfect");
    }

    @Test
    public void shouldGetTop(){
       List<Song> tops = songRepository.getTop();
       Song s = songRepository.getOne(Long.valueOf(1));
       assertThat(tops, hasItem(s));
    }

    @Test
    public void testCount(){
        playlistRepository.getPlaylistNumber(new Long(2));
        Mockito.verify(playlistRepository).getPlaylistNumber(new Long(2));
    }
}
