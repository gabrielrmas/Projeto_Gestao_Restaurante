package com.gabrielrmas.model;


public class Mesa {

	private int numeroMesa;
	private float valorTotal;
	private Pedido[] pedidos;
	
	
	public Pedido[] getPedidos() {
		return pedidos;
	}
	
	public void setPedidos(Pedido[] pedidos) {
		this.pedidos = pedidos;
	}
	
	public int getNumeroMesa() {
		return numeroMesa;
	}
	
	public void setNumeroMesa(int numeroMesa) {
		this.numeroMesa = numeroMesa;
	}
	
	public float getValorTotal() {
		valorTotal = 0;
		for (Pedido pedido : pedidos) { // pedido em amarelo vira todos os pedidos da iteração (invés de pedido 01 vira pedido)
			if ((pedido.getSituacao() == "Concluído") || pedido.getSituacao() == "Concluido") {
			valorTotal += pedido.getValor();}
			
		}
		
		return valorTotal;
	}
	
	public float porcentagemGarcom(float porcentagem) {
		return getValorTotal() * porcentagem;
		
	}	
	
}
