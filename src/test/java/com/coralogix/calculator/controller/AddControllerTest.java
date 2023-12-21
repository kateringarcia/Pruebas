package com.coralogix.calculator.controller;

import com.coralogix.calculator.PruebasController;
import com.coralogix.calculator.model.Film;
import com.coralogix.calculator.model.Result;
import com.coralogix.calculator.services.AddService;
import com.coralogix.calculator.services.AddServiceImplement;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.concurrent.CompletableFuture;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class AddControllerTest {

	@Mock
	AddServiceImplement addServiceImplement;
	
	@Mock
	PruebasController pruebasController;

	@Mock
	AddService addService;

	@InjectMocks
	PruebasController pruebasControllerInjectionMock;

	@Test
	void testPrueba1() {

		try {

			Film film = new Film();
			film.setEpisode_id(2);
			film.setId(1);
			film.setRelease_date("release_date");
			film.setTitle("title");

			CompletableFuture<Result> rta = new CompletableFuture<Result>();
			rta.get().setStatuscode(200);
			rta.get().setResponse(film);

			when(addServiceImplement.prueba1(1)).thenReturn(rta);

			assertEquals(rta, pruebasControllerInjectionMock.consumoService(1));

		} catch (Exception e) {
			e.getMessage();
		}

	}
	
	@Test
	void testPrueba1_2() {

		try {

			Film film = null;

			CompletableFuture<Result> rta = new CompletableFuture<Result>();
			rta.get().setStatuscode(404);
			rta.get().setResponse(film);

			when(addServiceImplement.prueba1(10)).thenReturn(rta);

			assertEquals(rta, pruebasControllerInjectionMock.consumoService(10));

		} catch (Exception e) {
			e.getMessage();
		}

	}
	
	@Test
	void testPrueba2() {

		try {

			Film film = new Film();
			film.setEpisode_id(2);
			film.setId(1);
			film.setRelease_date("release_date");
			film.setTitle("title");

			when(pruebasController.updateRegistry(film)).thenReturn(ResponseEntity.status(HttpStatus.OK).body(film));

		} catch (Exception e) {
			e.getMessage();
		}

	}
	
	@Test
	void testPrueba3() {

		try {

			Film film = new Film();
			film.setEpisode_id(2);
			film.setId(1);
			film.setRelease_date("release_date");
			film.setTitle("title");

			when(pruebasController.delateRegistry(film)).thenReturn(ResponseEntity.status(HttpStatus.OK).body(null));

		} catch (Exception e) {
			e.getMessage();
		}

	}

}
