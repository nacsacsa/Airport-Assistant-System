package com.example.Airport.Asistant.backend.service;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.example.Airport.Asistant.backend.service.dto.UserDto;

public interface UserService {
    UserDetailsService userDetailsService();
    
    UserDto findByName(String name);
}
