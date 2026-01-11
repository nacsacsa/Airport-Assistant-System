package com.example.Airport.Asistant.backend.service.impl;


import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.Airport.Asistant.backend.data.entity.UserEntity;
import com.example.Airport.Asistant.backend.data.repository.UserRepository;
import com.example.Airport.Asistant.backend.service.AuthenticationService;
import com.example.Airport.Asistant.backend.service.JwtService;
import com.example.Airport.Asistant.backend.service.dto.UserDto;

@Service
public class AuthenticationServiceImpl implements AuthenticationService {
    @Autowired
    UserRepository repo;
    @Autowired
    PasswordEncoder encoder;
    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    AuthenticationManager manager;
    @Autowired
    JwtService jwtService;

    @Override
    public String register(UserDto dto) {
        UserEntity userEntity = modelMapper.map(dto, UserEntity.class);
        userEntity.setPassword(encoder.encode(userEntity.getPassword()));
        userEntity = repo.save(userEntity);
        return jwtService.generateToken(userEntity);

    }

    @Override
    public String login(UserDto dto) {
        manager.authenticate(
                new UsernamePasswordAuthenticationToken(dto.getName(),dto.getPassword())
        );
        var user = repo.findByName(dto.getName());
        return jwtService.generateToken(user);
    }
}
