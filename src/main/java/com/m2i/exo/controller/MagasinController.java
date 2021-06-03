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

import com.m2i.exo.models.Magasin;
import com.m2i.exo.services.GenericService;

@RestController
@RequestMapping("magasins")
public class MagasinController {

	@Autowired
	private GenericService<Magasin> magasinService;

	@GetMapping()
	public List<Magasin> getAll() {
		return this.magasinService.getAll();
	}

	@GetMapping("/{id}")
	public Magasin getMagasinById(@PathVariable Long id) {
		return this.magasinService.getById(id);
	}

	@PostMapping()
	public void save(@RequestBody Magasin[] magasins) {
		this.magasinService.save(magasins);
	}

	@PutMapping()
	public void updateById( @RequestBody Magasin magasin) {
		this.magasinService.updateById(magasin);
	}

	@DeleteMapping("/{id}")
	public void deleteByID(@PathVariable Long id) {
		this.magasinService.deleteByID(id);
	}
	
	@DeleteMapping()
	public void deleteAll() {
		this.magasinService.deleteAll();
	}
}
