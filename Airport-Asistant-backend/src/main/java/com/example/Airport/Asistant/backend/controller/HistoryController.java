package com.example.Airport.Asistant.backend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.Airport.Asistant.backend.service.HistoryService;
import com.example.Airport.Asistant.backend.service.dto.HistoryDto;

@RestController
@RequestMapping("/api")
public class HistoryController {
	@Autowired
    HistoryService service;
	
	@GetMapping("/history")
    public List<HistoryDto> findAllHistory(){
        return service.findAll();
    }
}
