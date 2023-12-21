package com.coralogix.calculator.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class FilmTest {

	@DisplayName("id-Film")
	@Test
	void testFilmId() throws Exception {
		Film film = new Film();
		film.setId(5);
		Assertions.assertEquals(5, film.getId());	
	}
	
	@DisplayName("episodeId-Film")
	@Test
	void testFilmEpisodeId() throws Exception {
		Film film = new Film();
		film.setEpisode_id(4);
		Assertions.assertEquals(4, film.getEpisode_id());	
	}
	
	@DisplayName("releaseDate-Film")
	@Test
	void testReleaseDate() throws Exception {
		Film film = new Film();
		film.setRelease_date("release_date");
		Assertions.assertEquals("release_date", film.getRelease_date());	
	}
	
	@DisplayName("title-Film")
	@Test
	void testTitle() throws Exception {
		Film film = new Film();
		film.setTitle("Ejemplo");
		Assertions.assertEquals("Ejemplo", film.getTitle());	
	}
	
}
