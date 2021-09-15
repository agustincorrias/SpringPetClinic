package com.petclinic.corrias.services;

import java.util.Set;

import com.petclinic.corrias.model.Vet;


public interface VetService {
	
	Vet findById(Long id);
	
	Vet findByLastName(String lastName);
	
	Vet	save(Vet vet);
	
	Set<Vet> findAll();

}
