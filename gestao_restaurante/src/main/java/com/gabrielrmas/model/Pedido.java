package com.gabrielrmas.model;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

@Entity
public class Pedido {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long numeroPedido;
	
	@OneToOne(targetEntity = Item.class) // inves de usar joincolumn e especificar a coluna
	private Item item;
	
	@Enumerated(EnumType.STRING)
	private Situacoes situacao = Situacoes.NOVO;
	
	private String detalhar;
	
	@Min(1)
	private Integer quantidade;
	
	
	public Item getItem() {
		return item;
	}
	
	public void setItem(Item item) {
		this.item = item;
	}
	
	public String getDetalhar() {
		return detalhar;
	}
	
	public void setDetalhar(String detalhar) {
		this.detalhar = detalhar;
	}

	public Long getNumeroPedido() {
		return numeroPedido;
	}
	
	public Integer getQuantidade() {
		return quantidade;
	}
	
	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}
	
	public void setSituacao(Situacoes novo) {
		this.situacao = novo;
	}
	
	public Situacoes getSituacao() {
		return situacao;
		
	}
	
}
