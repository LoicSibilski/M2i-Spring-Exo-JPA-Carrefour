package com.m2i.exo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.m2i.exo.models.Produit;

public interface ProduitRepository extends JpaRepository<Produit, Long>{

}
