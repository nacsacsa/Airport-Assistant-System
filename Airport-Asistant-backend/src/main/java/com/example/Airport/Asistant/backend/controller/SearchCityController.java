package com.example.Airport.Asistant.backend.controller;

import java.time.LocalDateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.security.core.Authentication;

import com.example.Airport.Asistant.backend.service.HistoryService;
import com.example.Airport.Asistant.backend.service.SearchCityService;
import com.example.Airport.Asistant.backend.service.dto.CoordinateDto;
import com.example.Airport.Asistant.backend.service.dto.HistoryDto;

@RestController
@RequestMapping("/api")
public class SearchCityController {
	@Autowired
    SearchCityService SearchCityService;
	
	@Autowired
    HistoryService historyService;

    @GetMapping("/cities")
    public CoordinateDto search(@RequestParam String city, Authentication authentication){
    	String name = authentication.getName();
    	LocalDateTime date = LocalDateTime.now();
        //DateTimeFormatter dateFormated = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
    	HistoryDto historyDto = new HistoryDto(date, name, city);
    	historyService.save(historyDto);
        return SearchCityService.search(city);
    }
}
