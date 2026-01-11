package com.example.Airport.Asistant.backend.service;

import com.example.Airport.Asistant.backend.service.dto.CoordinateDto;

public interface SearchCityService {
	CoordinateDto search(String city);
}
