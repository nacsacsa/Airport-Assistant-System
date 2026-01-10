package com.example.Airport.Asistant.backend.data.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.Airport.Asistant.backend.data.entity.HistoryEntity;


	@Repository
	public interface HistoryRepository extends JpaRepository<HistoryEntity, Long> {
		HistoryEntity findByUsername(String username);
}
