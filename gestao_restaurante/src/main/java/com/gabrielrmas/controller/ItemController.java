package com.gabrielrmas.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gabrielrmas.model.Item;
import com.gabrielrmas.service.ItemService;

@RestController
@RequestMapping("/item")
public class ItemController {
	
	@Autowired
	private ItemService itemService;
	
	@PostMapping
	public String salvar(@RequestBody Item item) { 
		this.itemService.saveItem(item);
		return "item ok";
	}
	
	@GetMapping("/{name}") 
	public Item getItem(@PathVariable String name) { 
		return itemService.getItem(name);
	}
}
