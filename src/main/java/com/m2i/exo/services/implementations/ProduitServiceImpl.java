package com.m2i.exo.services.implementations;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.m2i.exo.models.Produit;
import com.m2i.exo.repositories.ProduitRepository;
import com.m2i.exo.services.GenericService;

public class ProduitServiceImpl implements GenericService<Produit>{

	@Autowired
	private ProduitRepository produitRepository;
	
	public List<Produit> getAll() {
		return this.produitRepository.findAll();
	}

	public Produit getById(Long id) {
		return this.produitRepository.findById(id).get();
	}
	
	public Produit save (Produit produit) {
		return this.produitRepository.save(produit);
	}
	
	public void save(Produit[] produit) {
		for (Produit prod : produit) {
			System.out.println("save prod : " + prod.toString());
			this.produitRepository.save(prod);
		}
	}
	
	public Produit updateById(Produit produit) {
		return this.produitRepository.save(produit);
	}
	
	public void deleteByID(Long id) {
		System.out.println("HERETIQUE AU BUCHER " + getById(id).toString());
		this.produitRepository.deleteById(id);;
	}
	
	public void deleteAll() {
		List<Produit> liste = this.produitRepository.findAll();
		for (Produit produit : liste) {
			this.produitRepository.delete(produit);
		}
		// TODO Auto-generated method stub
	}
}