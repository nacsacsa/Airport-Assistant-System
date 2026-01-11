package com.example.Airport.Asistant.backend.configuration.init;

import com.example.Airport.Asistant.backend.service.AuthenticationService;
import com.example.Airport.Asistant.backend.service.dto.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataInitializer implements CommandLineRunner {
    @Autowired
    private AuthenticationService service;

    @Override
    public void run(String... args) throws Exception {
        String defaultUsername = "user";
        String defaultPassword = "pass";
        UserDto user = new UserDto(defaultUsername, defaultPassword);
        service.register(user);
    }
}
