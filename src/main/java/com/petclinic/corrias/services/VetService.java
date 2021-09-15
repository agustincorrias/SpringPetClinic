package com.petclinic.corrias.services;

import java.util.Set;

import com.petclinic.corrias.model.Vet;


public interface VetService extends CrudService<Vet, Long>{
	
		Vet findByLastName(String lastName);
	
}
