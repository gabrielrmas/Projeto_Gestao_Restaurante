package com.gabrielrmas.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gabrielrmas.model.Pedido;

@Repository
public interface PedidoRepository extends JpaRepository<Pedido, Long> {
	
	public Pedido findByNumeroPedido(Long numeroPedido);
}