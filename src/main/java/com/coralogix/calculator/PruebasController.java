package com.coralogix.calculator;

import com.coralogix.calculator.model.Film;
import com.coralogix.calculator.model.Result;
import com.coralogix.calculator.services.AddService;
import com.coralogix.calculator.services.AddServiceImplement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

@RestController
@RequestMapping("add")
public class PruebasController {

	@Autowired
	private AddService addService;
	
    @Autowired
    private AddServiceImplement addServiceImplement;
    
	@GetMapping(path = "prueba1")
    public ResponseEntity<Object> consumoService(@RequestParam int idFilm) throws InterruptedException, ExecutionException {
			
		if(String.valueOf(idFilm).length() <= 3) {
			
			CompletableFuture<Result> rta = addServiceImplement.prueba1(idFilm);
			
			if(rta.get().getStatuscode() == 200) {
				return ResponseEntity.status(HttpStatus.OK).body(rta.get().getResponse());
			}else if(rta.get().getStatuscode() == 404) {
				return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);
			}else {
				return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Error en la solicitud");
			}
			
		}else {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Error en la solicitud");
		}
		
	}
	
	@PutMapping(path = "prueba2")
	public ResponseEntity<Object> updateRegistry(@RequestBody Film film) throws InterruptedException, ExecutionException {

		Film filmDB = addService.findById(film.getId());
		
		if(filmDB != null) {		
			filmDB = addService.save(film);
			return ResponseEntity.status(HttpStatus.OK).body(filmDB);
		}else {
			return ResponseEntity.status(HttpStatus.NO_CONTENT).body("Registro no encontrado");
		}

	}

	@DeleteMapping(path = "prueba3")
	public ResponseEntity<Object> delateRegistry(@RequestBody Film film) throws InterruptedException, ExecutionException {

		Film filmDB = addService.findById(film.getId());
		
		if(filmDB != null) {		
			addService.delete(film);
			return ResponseEntity.status(HttpStatus.OK).body(null);
		}else {
			return ResponseEntity.status(HttpStatus.NO_CONTENT).body("Error en la solicitud");
		}

	}
}
