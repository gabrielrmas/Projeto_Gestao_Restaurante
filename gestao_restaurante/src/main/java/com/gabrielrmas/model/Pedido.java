package com.gabrielrmas.model;

public class Pedido {

	private Item item;
	private String situacao = "Novo";
	private String detalhar;
	private int numeroPedido;
	private int quantidade;
	

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
	
	public float getValor() {
		return quantidade*item.getPreco(); // recebe o preço do alimento pelo BD
	}

	public int getNumeroPedido() {
		return numeroPedido;
	}
	
	public void setNumeroPedido(int numeroPedido) {
		this.numeroPedido = numeroPedido;
	}
	
	public int getQuantidade() {
		return quantidade;
	}
	
	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}
	
	public void setSituacao(String novaSituacao) {
		this.situacao = novaSituacao;
	}
	
	public String getSituacao() {
		return situacao;
		
	}
	
}
