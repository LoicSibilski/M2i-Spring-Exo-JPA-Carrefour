package com.m2i.exo.services;

import java.util.List;

import com.m2i.exo.models.Commande;

public interface CommandeService extends GenericService<Commande> {

	public List<Commande> findByClientId(Long id);
	
}
