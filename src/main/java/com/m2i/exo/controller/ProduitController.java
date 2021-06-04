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

import com.m2i.exo.models.Produit;
import com.m2i.exo.services.GenericService;

@RestController
@RequestMapping("produits")
public class ProduitController {

	@Autowired
	private GenericService<Produit> produitService;

	@GetMapping()
	public List<Produit> getAll() {
		return this.produitService.getAll();
	}

	@GetMapping("/{id}")
	public Produit getProduitById(@PathVariable Long id) {
		return this.produitService.getById(id);
	}

	@PostMapping()
	public void save(@RequestBody Produit[] produits) {
		this.produitService.save(produits);
	}

	@PutMapping()
	public void updateById( @RequestBody Produit produit) {
		this.produitService.updateById(produit);
	}

	@DeleteMapping("/{id}")
	public void deleteByID(@PathVariable Long id) {
		this.produitService.deleteByID(id);
	}
	
	@DeleteMapping()
	public void deleteAll() {
		this.produitService.deleteAll();
	}
}
