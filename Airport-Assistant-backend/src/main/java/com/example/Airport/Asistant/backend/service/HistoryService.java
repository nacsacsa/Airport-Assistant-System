package com.example.Airport.Asistant.backend.service;

import java.util.List;

import com.example.Airport.Asistant.backend.service.dto.HistoryDto;

public interface HistoryService {
	HistoryDto findByUsername(String username);
	
	void save(HistoryDto historyDto);
	
	List<HistoryDto> findAll();
}
