package com.m2i.exo.services.implementations;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.m2i.exo.models.Magasin;
import com.m2i.exo.repositories.MagasinRepository;
import com.m2i.exo.services.GenericService;

public class MagasinServiceImpl implements GenericService<Magasin>{

	@Autowired
	private MagasinRepository magasinRepository;
	
	public List<Magasin> getAll() {
		return this.magasinRepository.findAll();
	}

	public Magasin getById(Long id) {
		return this.magasinRepository.findById(id).get();
	}
	
	public Magasin save (Magasin magasin) {
		return this.magasinRepository.save(magasin);
	}
	
	public void save(Magasin[] magasin) {
		for (Magasin mag : magasin) {
			System.out.println("save mag : " + mag.toString());
			this.magasinRepository.save(mag);
		}
	}
	
	public Magasin updateById(Magasin magasin) {
		return this.magasinRepository.save(magasin);
	}
	
	public void deleteByID(Long id) {
		System.out.println("HERETIQUE AU BUCHER " + getById(id).toString());
		this.magasinRepository.deleteById(id);;
	}
	
	public void deleteAll() {
		List<Magasin> liste = this.magasinRepository.findAll();
		for (Magasin magasin : liste) {
			this.magasinRepository.delete(magasin);
		}
		// TODO Auto-generated method stub
	}
}