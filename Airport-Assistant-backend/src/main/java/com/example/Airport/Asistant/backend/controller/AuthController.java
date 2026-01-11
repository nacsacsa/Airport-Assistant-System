package com.example.Airport.Asistant.backend.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.Airport.Asistant.backend.service.AuthenticationService;
import com.example.Airport.Asistant.backend.service.dto.UserDto;

@RestController
@RequestMapping("/api")
public class AuthController {
    @Autowired
    AuthenticationService service;
    @PostMapping("/register")
    public String register(@RequestBody UserDto dto){
        return service.register(dto);
    }
    @PostMapping("/login")
    public String login(@RequestBody UserDto dto){
        return service.login(dto);
    }
}