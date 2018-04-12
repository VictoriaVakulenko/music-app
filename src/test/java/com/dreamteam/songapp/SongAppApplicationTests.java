package com.dreamteam.songapp;

import com.dreamteam.songapp.enteties.Song;
import com.dreamteam.songapp.repository.SongRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;


import java.util.List;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;



@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT,
classes = SongAppApplication.class)
@AutoConfigureMockMvc
@TestPropertySource(locations = "classpath:test.properties")
public class SongAppApplicationTests {

	@Autowired
	private MockMvc mvc;

	@Autowired
	private SongRepository repository;

	@Test
	public void getSongs(){
		List<Song> song = repository.findAll();
	}

	@Test
	public void findTopSongs() throws Exception{
		repository.getTop();
		mvc.perform(get("/top").contentType(MediaType.APPLICATION_JSON));
	}

	@Test
	public void contextLoads() {
	}


}
