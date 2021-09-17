package com.petclinic.corrias.services.map;

import java.util.Set;

import com.petclinic.corrias.model.Pet;
import com.petclinic.corrias.services.PetService;

public class PetServiceMap extends AbstractMapService<Pet, Long> implements PetService {

	
	@Override
	public Set<Pet> findAll() {
		return super.findAll();
	}
	
	@Override
	public Pet findById(Long id) {
		return super.findById(id);
	}

	@Override
	public Pet save(Pet object) {
		return super.save(object);
	}

	@Override
	public void delete(Pet object) {
		super.delete(object);
	}
	
	@Override
	public void deleteById(Long id) {
		super.deleteById(id);
	}

}
