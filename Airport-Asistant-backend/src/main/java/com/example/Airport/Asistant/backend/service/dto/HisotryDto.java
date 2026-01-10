package com.example.Airport.Asistant.backend.service.dto;

import java.util.Date;
import java.util.Objects;

public class HisotryDto {
	
	Date timestamp;
    String username;
    String city;

    public HisotryDto() {
    }

    public HisotryDto(Date timestamp, String username, String city) {
        this.timestamp = timestamp;
        this.username = username;
        this.city = city;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public void setName(Date timestamp) {
        this.timestamp = timestamp;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
    
    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        HisotryDto that = (HisotryDto) o;
        return Objects.equals(timestamp, that.timestamp) && Objects.equals(username, that.username) && Objects.equals(city, that.city);
    }

    @Override
    public int hashCode() {
        return Objects.hash(timestamp, username, city);
    }
}
