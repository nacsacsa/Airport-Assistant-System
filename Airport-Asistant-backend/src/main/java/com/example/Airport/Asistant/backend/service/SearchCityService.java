package com.example.Airport.Asistant.backend.service;

import com.example.Airport.Asistant.backend.service.dto.CordinateDto;

public interface SearchCityService {
	CordinateDto search(String city);
}
