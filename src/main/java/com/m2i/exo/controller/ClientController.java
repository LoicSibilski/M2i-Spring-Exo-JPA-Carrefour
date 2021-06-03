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

import com.m2i.exo.models.Client;
import com.m2i.exo.services.GenericService;

@RestController
@RequestMapping("clients")
public class ClientController {

	@Autowired
	private GenericService<Client> clientService;

	@GetMapping()
	public List<Client> getAll() {
		return this.clientService.getAll();
	}

	@GetMapping("/{id}")
	public Client getClientById(@PathVariable Long id) {
		return this.clientService.getById(id);
	}

	@PostMapping()
	public void save(@RequestBody Client[] clients) {
		this.clientService.save(clients);
	}

	@PutMapping()
	public void updateById( @RequestBody Client client) {
		this.clientService.updateById(client);
	}

	@DeleteMapping("/{id}")
	public void deleteByID(@PathVariable Long id) {
		this.clientService.deleteByID(id);
	}
	
	@DeleteMapping()
	public void deleteAll() {
		this.clientService.deleteAll();
	}
}
