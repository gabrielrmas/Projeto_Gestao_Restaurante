package com.gabrielrmas.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;



@Entity
public class Mesa {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer numeroMesa;
	private Float valorTotal;
	@OneToMany(cascade = CascadeType.ALL)
	private List<Pedido> pedidos;
	
	
	public List<Pedido> getPedidos() {
		return pedidos;
	}
	
	public void setPedidos(List<Pedido> pedidos) {
		this.pedidos = pedidos;
	}
	
	public Integer getNumeroMesa() {
		return numeroMesa;
	}
	
	public void setNumeroMesa(Integer numeroMesa) {
		this.numeroMesa = numeroMesa;
	}
	
	public Float getValorTotal() {
		valorTotal = (float) 0;
		for (Pedido pedido : pedidos) { // pedido em amarelo vira todos os pedidos da iteração (invés de pedido 01 vira pedido)
			if ((pedido.getSituacao() == "Concluído") || pedido.getSituacao() == "Finalizado") {
			valorTotal += pedido.getValor();}
			
		}
		
		return valorTotal;
	}
	
	public Float porcentagemGarcom(Float porcentagem) {
		return getValorTotal() * porcentagem;
		
	}	
	
}
