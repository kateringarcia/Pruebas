package com.coralogix.calculator.services;

import java.net.http.HttpResponse;
import java.util.concurrent.CompletableFuture;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.coralogix.calculator.model.Film;
import com.coralogix.calculator.model.Response;
import com.coralogix.calculator.model.Result;
import com.coralogix.calculator.util.ConsumoRestApi;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class AddServiceImplement {

	@Autowired
	ConsumoRestApi consumoRestApi;

	@Autowired
	private AddService addService;

	@Autowired
	private ObjectMapper mapper;

	public CompletableFuture<Result> prueba1(int idFilm) {

		Response httpResponse = consumoRestApi.consumoRestApl("https://swapi.dev/api/films/" + idFilm);

		CompletableFuture<Result> rta = httpResponse.getClient().sendAsync(httpResponse.getRequest(), HttpResponse.BodyHandlers.ofString())
				.thenApply(film -> {
					Result result = new Result();
					if (film.statusCode() == 200) {
						Film filmDB = null;
						try {
							filmDB = mapper.readValue(film.body(), Film.class);
						} catch (JsonMappingException e) {
							e.printStackTrace();
						} catch (JsonProcessingException e) {
							e.printStackTrace();
						}
						result.setStatuscode(200);
						result.setResponse(addService.save(filmDB));

						return result;

					} else if (film.statusCode() == 404) {

						result.setStatuscode(404);

						return result;

					} else {
						
						result.setStatuscode(400);

						return result;

					}
				});

		return rta;

	}

}
