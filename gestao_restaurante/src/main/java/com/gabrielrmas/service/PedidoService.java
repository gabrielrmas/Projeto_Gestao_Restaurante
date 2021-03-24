package com.gabrielrmas.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gabrielrmas.model.Pedido;
import com.gabrielrmas.model.Situacoes;
import com.gabrielrmas.model.Item;
import com.gabrielrmas.repository.PedidoRepository;
import com.gabrielrmas.repository.ItemRepository;

@Service
public class PedidoService {
	
	@Autowired
	private PedidoRepository pedidoRepository;
	
	@Autowired
	private ItemRepository itemRepository;
	
	public void savePedido(Pedido pedido) {
		pedido.setSituacao(Situacoes.NOVO);
		if (pedido.getItem().getId() != null 
	    && itemRepository.existsById(pedido.getItem().getId())) {
			pedidoRepository.save(pedido);
		}
		else {
			Item itemNovo = itemRepository.save(pedido.getItem());
			pedido.setItem(itemNovo);
			pedidoRepository.save(pedido);
		}
		
	}
	
	public Pedido getPedido(Long numeroPedido) {
		return pedidoRepository.findByNumeroPedido(numeroPedido);
	}
	
	public Float getValor(Pedido pedido) {
		Item item = pedido.getItem();
		return pedido.getQuantidade()*item.getPreco(); // recebe o preço do alimento pelo BD
	}
	
}