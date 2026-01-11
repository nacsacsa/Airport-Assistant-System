package com.example.Airport.Asistant.backend.data.entity;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "history")
public class HistoryEntity {
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name = "timestamp")
    private LocalDateTime timestamp;
    @Column(name = "username")
    private String username;
    @Column(name = "city")
    private String city;
    
    public HistoryEntity() {
    }
    
    public HistoryEntity(long id, LocalDateTime timestamp, String username, String city) {
    	this.id = id;
    	this.timestamp = timestamp;
    	this.username = username;
    	this.city = city;
    }
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    
    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
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
        HistoryEntity that = (HistoryEntity) o;
        return Objects.equals(id, that.id) && Objects.equals(timestamp, that.timestamp) && Objects.equals(username, that.username) && Objects.equals(city, that.city);
    }
    @Override
    public int hashCode() {
        return Objects.hash(id, timestamp, username, city);
    }
}
