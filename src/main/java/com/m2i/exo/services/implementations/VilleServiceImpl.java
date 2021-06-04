package com.m2i.exo.services.implementations;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.m2i.exo.models.Ville;
import com.m2i.exo.repositories.VilleRepository;
import com.m2i.exo.services.GenericService;

public class VilleServiceImpl implements GenericService<Ville>{

	@Autowired
	private VilleRepository villeRepository;
	
	public List<Ville> getAll() {
		return this.villeRepository.findAll();
	}

	public Ville getById(Long id) {
		return this.villeRepository.findById(id).get();
	}
	
	public Ville save (Ville ville) {
		return this.villeRepository.save(ville);
	}
	
	public void save(Ville[] ville) {
		for (Ville vil : ville) {
			System.out.println("save vil : " + vil.toString());
			this.villeRepository.save(vil);
		}
	}
	
	public Ville updateById(Ville ville) {
		return this.villeRepository.save(ville);
	}
	
	public void deleteByID(Long id) {
		System.out.println("HERETIQUE AU BUCHER " + getById(id).toString());
		this.villeRepository.deleteById(id);;
	}
	
	public void deleteAll() {
		List<Ville> liste = this.villeRepository.findAll();
		for (Ville ville : liste) {
			this.villeRepository.delete(ville);
		}
		// TODO Auto-generated method stub
	}
}