package com.example.Airport.Asistant.backend.service.impl;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Airport.Asistant.backend.data.entity.HistoryEntity;
import com.example.Airport.Asistant.backend.data.repository.HistoryRepository;
import com.example.Airport.Asistant.backend.service.HistoryService;
import com.example.Airport.Asistant.backend.service.dto.HistoryDto;

@Service
public class HistoryServiceImpl implements HistoryService{
	
	@Autowired
    HistoryRepository repository;
	
	@Autowired
    ModelMapper mapper;
	
	@Override
	public HistoryDto findByUsername(String username) {
		HistoryEntity entity = repository.findByUsername(username);
        return mapper.map(entity, HistoryDto.class);
	}

	@Override
	public void save(HistoryDto historyDto) {
		HistoryEntity history = mapper.map(historyDto, HistoryEntity.class);
		history = repository.save(history);
	}

	@Override
	public List<HistoryDto> findAll() {
		List<HistoryEntity> list = repository.findAll();
        return mapper.map(list, new TypeToken<List<HistoryDto>>(){}.getType());
	}
}
