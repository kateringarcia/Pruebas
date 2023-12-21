package com.coralogix.calculator.util;

import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;

import com.coralogix.calculator.model.Response;

import java.net.http.HttpClient.Redirect;
import java.net.http.HttpClient.Version;

public class ConsumoRestApi {
	
	
	public Response consumoRestApl(String url) {
		
		Response response= new Response();
		HttpRequest request = null;	  
		 
		  
		try {
			
	  	  	HttpClient client = HttpClient.newBuilder()
	  		      .version(Version.HTTP_2)
	  		      .followRedirects(Redirect.NORMAL)
	  		      .build();
	  	  	
			request = HttpRequest.newBuilder()
			     .uri(new URI(url))
			     .GET()
			     .build();
			
			response.setClient(client);
			response.setRequest(request);
			
			return response;
			
		} catch (URISyntaxException e) {
			e.getMessage();
			return null;
		}
	}
}
