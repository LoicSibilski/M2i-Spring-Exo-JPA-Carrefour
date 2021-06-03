package com.m2i.exo.services.implementations;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.m2i.exo.models.Commande;
import com.m2i.exo.repositories.CommandeRepository;
import com.m2i.exo.services.GenericService;

public class CommandeServiceImpl implements GenericService<Commande>{

	@Autowired
	private CommandeRepository commandeRepository;
	
	public List<Commande> getAll() {
		return this.commandeRepository.findAll();
	}

	public Commande getById(Long id) {
		return this.commandeRepository.findById(id).get();
	}
	
	public Commande save (Commande commande) {
		return this.commandeRepository.save(commande);
	}
	
	public void save(Commande[] commande) {
		for (Commande comm : commande) {
			System.out.println("save comm : " + comm.toString());
			this.commandeRepository.save(comm);
		}
	}
	
	public Commande updateById(Commande commande) {
		return this.commandeRepository.save(commande);
	}
	
	public void deleteByID(Long id) {
		System.out.println("HERETIQUE AU BUCHER " + getById(id).toString());
		this.commandeRepository.deleteById(id);;
	}
	
	public void deleteAll() {
		List<Commande> liste = this.commandeRepository.findAll();
		for (Commande commande : liste) {
			this.commandeRepository.delete(commande);
		}
		// TODO Auto-generated method stub
	}
}