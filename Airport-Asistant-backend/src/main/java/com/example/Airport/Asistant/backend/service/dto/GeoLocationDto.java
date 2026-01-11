package com.example.Airport.Asistant.backend.service.dto;

import java.util.List;
import java.util.Objects;

public class GeoLocationDto {
	List<CoordinateDto> coordinates;
	
	public GeoLocationDto() {
    }

    public GeoLocationDto(List<CoordinateDto> coordinates) {
        this.coordinates = coordinates;
    }

    public List<CoordinateDto> getCoordinates() {
        return coordinates;
    }

    public void setCoordinates(List<CoordinateDto> coordinates) {
        this.coordinates = coordinates;
    }

    
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GeoLocationDto that = (GeoLocationDto) o;
        return Objects.equals(coordinates, that.coordinates);
    }

    @Override
    public int hashCode() {
        return Objects.hash(coordinates);
    }
}
