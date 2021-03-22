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
	private ItemService item;
	
	@PostMapping
	public String salvar(@RequestBody Item item) { // request body necessário pra receber as informações em json (body/raw - postman)
		this.item.saveItem(item);
		return "redirect:/item";
	}
	
	@GetMapping("/{name}") // aqui eu digo q a variável na url vem com o /name
	public Item getItem(@PathVariable String name) { // seta o caminho do get para o nome dado pelo postman
		return item.getItem(name);
	}
}
