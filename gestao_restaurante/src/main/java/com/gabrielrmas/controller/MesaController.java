package com.gabrielrmas.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gabrielrmas.model.Mesa;
import com.gabrielrmas.model.Pedido;
import com.gabrielrmas.service.MesaService;

@RestController
@RequestMapping("/mesa")
public class MesaController {
	
	@Autowired
	private MesaService mesaService;
	
	@PostMapping
	public String salvar(@RequestBody Mesa mesa) {
		this.mesaService.saveMesa(mesa);
		return "mesa ok";
	}
	
	@GetMapping("/{numeroMesa}")
	public Mesa getMesa(@PathVariable Integer numeroMesa) {
		return mesaService.getMesa(numeroMesa);
	}
	
	@GetMapping("/valor/{numeroMesa}")
	public Float getValorTotal(@PathVariable Integer numeroMesa){
		return this.mesaService.getValorTotal(mesaService.getMesa(numeroMesa));
	}
	
	@GetMapping("/listapedidos/{numeroMesa}") //não está funcionando
	public List<Pedido> listPedidos(@PathVariable Integer numeroMesa) {
		return mesaService.listPedidos(numeroMesa);
	}
	
}