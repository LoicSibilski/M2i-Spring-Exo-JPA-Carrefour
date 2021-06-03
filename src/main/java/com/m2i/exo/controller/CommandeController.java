package com.m2i.exo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.m2i.exo.models.Commande;
import com.m2i.exo.services.GenericService;

@RestController
@RequestMapping("commandes")
public class CommandeController {

	@Autowired
	private GenericService<Commande> commandeService;

	@GetMapping()
	public List<Commande> getAll() {
		return this.commandeService.getAll();
	}

	@GetMapping("/{id}")
	public Commande getCommandeById(@PathVariable Long id) {
		return this.commandeService.getById(id);
	}

	@PostMapping()
	public void save(@RequestBody Commande[] commandes) {
		this.commandeService.save(commandes);
	}

	@PutMapping()
	public void updateById( @RequestBody Commande commande) {
		this.commandeService.updateById(commande);
	}

	@DeleteMapping("/{id}")
	public void deleteByID(@PathVariable Long id) {
		this.commandeService.deleteByID(id);
	}
	
	@DeleteMapping()
	public void deleteAll() {
		this.commandeService.deleteAll();
	}
}
