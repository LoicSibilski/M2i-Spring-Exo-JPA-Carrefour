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

import com.m2i.exo.models.Ville;
import com.m2i.exo.services.GenericService;

@RestController
@RequestMapping("villes")
public class VilleController {

	@Autowired
	private GenericService<Ville> villeService;

	@GetMapping()
	public List<Ville> getAll() {
		return this.villeService.getAll();
	}

	@GetMapping("/{id}")
	public Ville getVilleById(@PathVariable Long id) {
		return this.villeService.getById(id);
	}

	@PostMapping()
	public void save(@RequestBody Ville[] villes) {
		this.villeService.save(villes);
	}

	@PutMapping()
	public void updateById( @RequestBody Ville ville) {
		this.villeService.updateById(ville);
	}

	@DeleteMapping("/{id}")
	public void deleteByID(@PathVariable Long id) {
		this.villeService.deleteByID(id);
	}
	
	@DeleteMapping()
	public void deleteAll() {
		this.villeService.deleteAll();
	}
}
