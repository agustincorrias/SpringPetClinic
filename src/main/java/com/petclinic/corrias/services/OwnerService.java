package com.petclinic.corrias.services;

import java.util.Set;

import com.petclinic.corrias.model.Owner;

public interface OwnerService {
	
	Owner findById(Long id);
	
	Owner findByLastName(String lastName);
	
	Owner save(Owner owner);
	
	Set<Owner> findAll();

}
