package com.coralogix.calculator.model;

import java.net.http.HttpClient;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class ResponseTest {

	@DisplayName("client-Response")
	@Test
	void testClient() throws Exception {
		
		HttpClient httpClient = null;
		
		Response response = new Response();
		response.setClient(httpClient);
		
		Assertions.assertEquals(httpClient, response.getClient());	
	}
	
	@DisplayName("request-Response")
	@Test
	void testRequest() throws Exception {
		
		HttpClient httpClient = null;
		
		Response response = new Response();
		response.setClient(httpClient);
		
		Assertions.assertEquals(httpClient, response.getClient());	
	}

}
