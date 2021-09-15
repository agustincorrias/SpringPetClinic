package com.petclinic.corrias.services.map;

import java.util.Set;

import com.petclinic.corrias.model.Owner;
import com.petclinic.corrias.services.OwnerService;

public class OwnerServiceMap extends AbstractMapService<Owner, Long> implements OwnerService {

	@Override
	public Set<Owner> findAll() {
		return super.findAll();
	}

	@Override
	public Owner findById(Long id) {
		return super.findById(id);
	}

	@Override
	public Owner save(Owner object) {
		return super.save(object.getId(), object);
	}

	@Override
	public void delete(Owner object) {
		super.delete(object);
	}

	@Override
	public void deleteById(Long id) {
		super.deleteById(id);
	}

	@Override
	public Owner findByLastName(String lastName) {
		return this.map.entrySet().stream().filter(entry -> entry.getValue().getLastName().equals(lastName))
				.map(entry -> entry.getValue()).findFirst().orElse(null);
	}

}
