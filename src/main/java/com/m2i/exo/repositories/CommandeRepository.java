package com.m2i.exo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.m2i.exo.models.Commande;

public interface CommandeRepository extends JpaRepository<Commande, Long>{

}
