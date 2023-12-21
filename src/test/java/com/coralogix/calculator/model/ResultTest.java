package com.coralogix.calculator.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class ResultTest {

	@DisplayName("statuscode-Result")
	@Test
	void testResultStatusCode() throws Exception {
		Result result = new Result();
		result.setStatuscode(200);
		Assertions.assertEquals(200, result.getStatuscode());	
	}
	
	@DisplayName("response-Result")
	@Test
	void testResponse() throws Exception {
		
		Film film = new Film();
		film.setId(1);
		film.setTitle("Title");
		film.setEpisode_id(2);
		film.setRelease_date("release_date");
		
		Result result = new Result();
		result.setResponse(film);
		Assertions.assertEquals(film, result.getResponse());	
	}	
	
}
