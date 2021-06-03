package com.m2i.exo.services.implementations;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.m2i.exo.models.Categorie;
import com.m2i.exo.repositories.CategorieRepository;
import com.m2i.exo.services.GenericService;

public class CategorieServiceImpl implements GenericService<Categorie>{

	@Autowired
	private CategorieRepository categorieRepository;
	
	public List<Categorie> getAll() {
		return this.categorieRepository.findAll();
	}

	public Categorie getById(Long id) {
		return this.categorieRepository.findById(id).get();
	}
	
	public Categorie save (Categorie categorie) {
		return this.categorieRepository.save(categorie);
	}
	
	public void save(Categorie[] categorie) {
		for (Categorie cate : categorie) {
			System.out.println("save cate : " + cate.toString());
			this.categorieRepository.save(cate);
		}
	}
	
	public Categorie updateById(Categorie categorie) {
		return this.categorieRepository.save(categorie);
	}
	
	public void deleteByID(Long id) {
		System.out.println("HERETIQUE AU BUCHER " + getById(id).toString());
		this.categorieRepository.deleteById(id);;
	}
	
	public void deleteAll() {
		List<Categorie> liste = this.categorieRepository.findAll();
		for (Categorie categorie : liste) {
			this.categorieRepository.delete(categorie);
		}
		// TODO Auto-generated method stub
	}
}
