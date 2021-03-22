package com.gabrielrmas.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gabrielrmas.model.Item;

@Repository
public interface ItemRepository extends JpaRepository<Item, Long> {
	
	public Item findByNome(String nome);
	
}
