package com.coralogix.calculator;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.coralogix.calculator.util.ConsumoRestApi;

@SpringBootApplication
public class CalculatorApplication {

	public static void main(String[] args) {
		SpringApplication.run(CalculatorApplication.class, args);
	}

	@Bean
	public ConsumoRestApi consumoRest() {
	    return new ConsumoRestApi();
	}

}
