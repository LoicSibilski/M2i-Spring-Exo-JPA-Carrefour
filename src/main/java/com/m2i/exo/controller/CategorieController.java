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

import com.m2i.exo.models.Categorie;
import com.m2i.exo.services.GenericService;

@RestController
@RequestMapping("categories")
public class CategorieController {

	@Autowired
	private GenericService<Categorie> categorieService;

	@GetMapping()
	public List<Categorie> getAll() {
		return this.categorieService.getAll();
	}

	@GetMapping("/{id}")
	public Categorie getCategorieById(@PathVariable Long id) {
		return this.categorieService.getById(id);
	}

	@PostMapping()
	public void save(@RequestBody Categorie[] categories) {
		this.categorieService.save(categories);
	}

	@PutMapping()
	public void updateById( @RequestBody Categorie categorie) {
		this.categorieService.updateById(categorie);
	}

	@DeleteMapping("/{id}")
	public void deleteByID(@PathVariable Long id) {
		this.categorieService.deleteByID(id);
	}
	
	@DeleteMapping()
	public void deleteAll() {
		this.categorieService.deleteAll();
	}
}
