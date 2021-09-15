package com.petclinic.corrias.services;


import com.petclinic.corrias.model.Pet;

public interface PetService extends CrudService<Pet, Long> {
	
	Pet findByLastName(String lastName);
	
}
