package com.coralogix.calculator.services;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.coralogix.calculator.model.Film;

@Repository
public interface AddService extends JpaRepository<Film, Long>{
	
	 Film findById(long id);
	 
}
