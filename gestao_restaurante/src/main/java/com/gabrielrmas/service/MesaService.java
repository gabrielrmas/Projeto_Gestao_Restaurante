package com.gabrielrmas.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gabrielrmas.model.Mesa;
import com.gabrielrmas.model.Pedido;
import com.gabrielrmas.model.Situacoes;
import com.gabrielrmas.repository.MesaRepository;

@Service
public class MesaService {
	
	@Autowired
	private MesaRepository mesaRepository;
	
	@Autowired
	private PedidoService pedidoService;
	
	public void saveMesa(Mesa mesa) {
		mesaRepository.save(mesa);
	}
	
	public Mesa getMesa(Integer numeroMesa) {
		return mesaRepository.findByNumeroMesa(numeroMesa);
	}
	
	public Float getValorTotal(Mesa mesa) {
		float valorTotal = 0;
		for (Pedido pedido : mesa.getPedidos()) { 
			if ((pedido.getSituacao() == Situacoes.CONCLUIDO) || pedido.getSituacao() == Situacoes.FINALIZADO) {
			valorTotal += pedidoService.getValor(pedido);
			}
		}
		return valorTotal;
	}
	
	public List<Pedido> listPedidos(Integer numeroMesa){ //não está funcionando
		return mesaRepository.findByNumeroMesa(numeroMesa).getPedidos();
	}
		
}
