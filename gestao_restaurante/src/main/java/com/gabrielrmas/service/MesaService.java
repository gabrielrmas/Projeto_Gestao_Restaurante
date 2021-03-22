package com.gabrielrmas.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.gabrielrmas.model.Mesa;
import com.gabrielrmas.repository.MesaRepository;

public class MesaService {
	
	@Autowired
	private MesaRepository mesaRepository;
	
	public void saveMesa(Mesa mesa) {
		mesaRepository.save(mesa);
	}
}
