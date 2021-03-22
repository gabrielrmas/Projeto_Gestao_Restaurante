package com.gabrielrmas.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gabrielrmas.model.Mesa;

@Repository
public interface MesaRepository extends JpaRepository<Mesa, Integer> {
	
}