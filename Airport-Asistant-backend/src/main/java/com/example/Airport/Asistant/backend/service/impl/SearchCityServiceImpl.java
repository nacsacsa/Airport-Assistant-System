package com.example.Airport.Asistant.backend.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.example.Airport.Asistant.backend.service.SearchCityService;
import com.example.Airport.Asistant.backend.service.dto.CoordinateDto;
import com.example.Airport.Asistant.backend.service.dto.GeoLocationDto;

@Service
public class SearchCityServiceImpl implements SearchCityService{
	
	private final RestTemplate restTemplate = new RestTemplate();

	@Override
	public CoordinateDto search(String city) {
		String baseUrl = "https://geodb-free-service.wirefreethought.com/v1/geo/places?limit=1&offset=0&types=CITY&sort=-population&namePrefix=";
		String url = baseUrl + city;
		GeoLocationDto response = restTemplate.getForObject(url, GeoLocationDto.class);
		if (response == null ||
				response.getData() == null ||
				response.getData().isEmpty()) {
			return null;
		}
        return response.getData().get(0);
	}
}
