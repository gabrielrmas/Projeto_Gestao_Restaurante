package com.gabrielrmas.model;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Pedido {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long numeroPedido;
	@OneToOne(targetEntity = Item.class) // inves de usar joincolumn e especificar a coluna
	private Item item;                   
	private String situacao = "Novo";
	private String detalhar;
	private Integer quantidade;
	
	@Enumerated(EnumType.STRING)
	private Situacoes newSituacao;
	
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
	
	
	public Float getValor() {
		return quantidade*item.getPreco(); // recebe o preço do alimento pelo BD
	}

	public Long getNumeroPedido() {
		return numeroPedido;
	}
	
	public void setNumeroPedido(Long numeroPedido) {
		this.numeroPedido = numeroPedido;
	}
	
	public Integer getQuantidade() {
		return quantidade;
	}
	
	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}
	
	public void setSituacao(String novaSituacao) {
		this.situacao = novaSituacao;
	}
	
	public String getSituacao() {
		return situacao;
		
	}
	
}
