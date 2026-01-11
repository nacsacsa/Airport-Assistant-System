package com.example.Airport.Asistant.backend.data.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.Airport.Asistant.backend.data.entity.UserEntity;

	@Repository
	public interface UserRepository extends JpaRepository<UserEntity, Long> {
		UserEntity findByName(String name);
}