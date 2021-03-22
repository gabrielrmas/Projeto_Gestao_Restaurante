package com.gabrielrmas.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.gabrielrmas.model.Pedido;
import com.gabrielrmas.repository.PedidoRepository;

public class PedidoService {
	
	@Autowired
	private PedidoRepository pedidoRepository;
	
	public void savePedido(Pedido pedido) {
		pedidoRepository.save(pedido);
	}
}
