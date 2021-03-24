package com.gabrielrmas.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.Min;



@Entity
public class Mesa {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer numeroMesa;
	
	@Min(0)
	private Float valorTotal;
	
	@OneToMany(cascade = CascadeType.ALL)
	private List<Pedido> pedidos;
	
	
	public List<Pedido> getPedidos() {
		return pedidos;
	}
	
	public void setPedidos(Pedido pedidos) {
		this.pedidos.add(pedidos);
	}
	
	public Integer getNumeroMesa() {
		return numeroMesa;
	}
	
	public void setNumeroMesa(Integer numeroMesa) {
		this.numeroMesa = numeroMesa;
	}
	
	
}
