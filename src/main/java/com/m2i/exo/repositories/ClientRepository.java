package com.m2i.exo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.m2i.exo.models.Client;

public interface ClientRepository extends JpaRepository<Client, Long> {

}
