package com.example.Airport.Asistant.backend.service;

import com.example.Airport.Asistant.backend.service.dto.UserDto;

public interface AuthenticationService {
    String login(UserDto dto);

    String register(UserDto dto);
}