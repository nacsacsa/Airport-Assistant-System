package com.example.Airport.Asistant.backend.service.impl;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.Airport.Asistant.backend.data.entity.UserEntity;
import com.example.Airport.Asistant.backend.data.repository.UserRepository;
import com.example.Airport.Asistant.backend.service.UserService;
import com.example.Airport.Asistant.backend.service.dto.UserDto;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserRepository repository;
    @Autowired
    ModelMapper mapper;

    @Override
    public UserDetailsService userDetailsService() {

        return new UserDetailsService() {
            @Override
            public UserDetails loadUserByUsername(String name) throws UsernameNotFoundException {
                return repository.findByName(name);
            }
        };
    }

	@Override
	public UserDto findByName(String name) {
		UserEntity entity = repository.findByName(name);
        return mapper.map(entity, UserDto.class);
	}

}
