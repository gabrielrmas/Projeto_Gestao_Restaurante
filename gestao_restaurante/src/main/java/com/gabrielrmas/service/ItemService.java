package com.gabrielrmas.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gabrielrmas.model.Item;
import com.gabrielrmas.repository.ItemRepository;

@Service
public class ItemService {
	
	@Autowired
	private ItemRepository itemRepository;
	
	public void saveItem(Item item) {
		itemRepository.save(item);
	}
	
	public Item getItem(String nome) {
		return itemRepository.findByNome(nome);
	}
}
