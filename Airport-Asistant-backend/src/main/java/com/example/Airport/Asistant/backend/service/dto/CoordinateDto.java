package com.example.Airport.Asistant.backend.service.dto;

import java.util.Objects;

public class CoordinateDto {
	Double lattitutde;
	Double longitude;

    public CoordinateDto() {
    }

    public CoordinateDto(Double lattitutde, Double longitude) {
        this.lattitutde = lattitutde;
        this.longitude = longitude;
    }

    public Double getLattitutde() {
        return lattitutde;
    }

    public void seLattitutde(Double lattitutde) {
        this.lattitutde = lattitutde;
    }

    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CoordinateDto that = (CoordinateDto) o;
        return Objects.equals(lattitutde, that.lattitutde) && Objects.equals(longitude, that.longitude);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lattitutde, longitude);
    }
}
