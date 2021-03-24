package com.gabrielrmas.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gabrielrmas.model.Pedido;
import com.gabrielrmas.service.PedidoService;

@RestController
@RequestMapping("/pedido")
public class PedidoController {
	
	@Autowired
	private PedidoService pedidoService;
	
	
	@PostMapping
	public String salvar(@RequestBody Pedido pedido) {
		this.pedidoService.savePedido(pedido);
		return "pedido ok";
	}

	@GetMapping("/{numeroPedido}")
	public Pedido getPedido(@PathVariable Long numeroPedido) {
		return pedidoService.getPedido(numeroPedido);
	}
	
	@GetMapping("/valor/{numeroPedido}")
	public Float getValor(@PathVariable Long numeroPedido) {
		return this.pedidoService.getValor(pedidoService.getPedido(numeroPedido));
	}
}
