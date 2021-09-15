package com.petclinic.corrias.services;

import java.util.Set;

import com.petclinic.corrias.model.Pet;


public interface PetService {
	
	Pet findByLastName(String lastName);
	
	Pet	save(Pet pet);
	
	Set<Pet> findAll();
	
}
