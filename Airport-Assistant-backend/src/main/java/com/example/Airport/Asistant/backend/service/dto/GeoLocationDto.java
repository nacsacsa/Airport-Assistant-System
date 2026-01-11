package com.example.Airport.Asistant.backend.service.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@JsonIgnoreProperties(ignoreUnknown = true)
public class GeoLocationDto {

    private List<CoordinateDto> data = new ArrayList<>();

    public List<CoordinateDto> getData() {
        return data;
    }

    public void setData(List<CoordinateDto> data) {
        this.data = data;
    }
}
