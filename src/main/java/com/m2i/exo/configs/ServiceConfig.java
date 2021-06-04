package com.m2i.exo.configs;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.m2i.exo.models.Categorie;
import com.m2i.exo.models.Client;
import com.m2i.exo.models.Magasin;
import com.m2i.exo.models.Produit;
import com.m2i.exo.models.Ville;
import com.m2i.exo.services.CommandeService;
import com.m2i.exo.services.GenericService;
import com.m2i.exo.services.implementations.CategorieServiceImpl;
import com.m2i.exo.services.implementations.ClientServiceImpl;
import com.m2i.exo.services.implementations.CommandeServiceImpl;
import com.m2i.exo.services.implementations.MagasinServiceImpl;
import com.m2i.exo.services.implementations.ProduitServiceImpl;
import com.m2i.exo.services.implementations.VilleServiceImpl;

@Configuration
public class ServiceConfig {

	@Bean
	public GenericService<Categorie> categorieServiceFactory() {
		return new CategorieServiceImpl();
	}

	@Bean
	public GenericService<Client> clientServiceFactory() {
		return new ClientServiceImpl();
	}

	@Bean
	public CommandeService commandeServiceFactory() {
		return new CommandeServiceImpl();
	}

	@Bean
	public GenericService<Magasin> magasinServiceFactory() {
		return new MagasinServiceImpl();
	}

	@Bean
	public GenericService<Produit> produitServiceFactory() {
		return new ProduitServiceImpl();
	}

	@Bean
	public GenericService<Ville> villeServiceFactory() {
		return new VilleServiceImpl();
	}
}
