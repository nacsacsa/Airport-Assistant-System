package com.example.Airport.Asistant.backend;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class AirportAssistantBackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(AirportAssistantBackendApplication.class, args);
	}
	
	@Bean
	ModelMapper modelMapper(){
		return new ModelMapper();
	}

}
