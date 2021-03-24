package com.gabrielrmas.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gabrielrmas.model.Mesa;
import com.gabrielrmas.model.Pedido;
import com.gabrielrmas.service.MesaService;
import com.gabrielrmas.service.PedidoService;

@RestController
@RequestMapping("/mesa")
public class MesaController {
	
	@Autowired
	private MesaService mesaService;
	
	@Autowired
	private PedidoService pedidoService;
	
	@PostMapping
	public String salvar(@RequestBody Mesa mesa) {
		this.mesaService.saveMesa(mesa);
		return "mesa ok";
	}
	
	@PatchMapping("/{numeroMesa}")
	public void addPedido(@PathVariable Integer numeroMesa, @RequestBody Pedido pedido) {
		Pedido newPedido = pedidoService.getPedido(pedido.getNumeroPedido());
		//Mesa mesa = this.mesaService.getMesa(numeroMesa);
		//List<Pedido> listaDePedidos;
		//listaDePedidos.add(newPedido);
		this.mesaService.getMesa(numeroMesa).setPedidos(newPedido);
		//mesa.setPedidos(listaDePedidos);
	}
	
	@GetMapping
	public List<Mesa> getMesas() {
		return mesaService.getMesas();
	}
	
	@GetMapping("/{numeroMesa}")
	public Mesa getMesa(@PathVariable Integer numeroMesa) {
		return mesaService.getMesa(numeroMesa);
	}
	
	@GetMapping("/valor/{numeroMesa}")
	public Float getValorTotal(@PathVariable Integer numeroMesa){
		return this.mesaService.getValorTotal(numeroMesa);
	}
	
	@GetMapping("/listapedidos/{numeroMesa}") //não está funcionando
	public List<Pedido> listPedidos(@PathVariable Integer numeroMesa) {
		return mesaService.listPedidos(numeroMesa);
	}
	
}