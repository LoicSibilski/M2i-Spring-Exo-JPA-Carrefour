package com.m2i.exo.services.implementations;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.m2i.exo.models.Client;
import com.m2i.exo.repositories.ClientRepository;
import com.m2i.exo.services.GenericService;

public class ClientServiceImpl implements GenericService<Client>{

	@Autowired
	private ClientRepository clientRepository;
	
	public List<Client> getAll() {
		return this.clientRepository.findAll();
	}

	public Client getById(Long id) {
		return this.clientRepository.findById(id).get();
	}
	
	public Client save (Client client) {
		return this.clientRepository.save(client);
	}
	
	public void save(Client[] client) {
		for (Client cli : client) {
			System.out.println("save cli : " + cli.toString());
			this.clientRepository.save(cli);
		}
	}
	
	public Client updateById(Client client) {
		return this.clientRepository.save(client);
	}
	
	public void deleteByID(Long id) {
		System.out.println("HERETIQUE AU BUCHER " + getById(id).toString());
		this.clientRepository.deleteById(id);;
	}
	
	public void deleteAll() {
		List<Client> liste = this.clientRepository.findAll();
		for (Client client : liste) {
			this.clientRepository.delete(client);
		}
		// TODO Auto-generated method stub
	}
}