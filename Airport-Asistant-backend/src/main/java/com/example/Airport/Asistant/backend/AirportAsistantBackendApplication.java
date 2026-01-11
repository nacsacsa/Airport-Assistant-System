package com.example.Airport.Asistant.backend;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class AirportAsistantBackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(AirportAsistantBackendApplication.class, args);
	}
	
	@Bean
	ModelMapper modelMapper(){
		return new ModelMapper();
	}

}
