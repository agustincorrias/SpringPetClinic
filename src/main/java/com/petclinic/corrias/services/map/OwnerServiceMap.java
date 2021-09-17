package com.petclinic.corrias.services.map;

import java.util.Set;
import java.util.function.Consumer;

import org.springframework.stereotype.Service;

import com.petclinic.corrias.model.Owner;
import com.petclinic.corrias.model.Pet;
import com.petclinic.corrias.model.PetType;
import com.petclinic.corrias.services.OwnerService;
import com.petclinic.corrias.services.PetService;
import com.petclinic.corrias.services.PetTypeService;

@Service
public class OwnerServiceMap extends AbstractMapService<Owner, Long> implements OwnerService {

	private final PetTypeService petTypeService;
	private final PetService petService;

	public OwnerServiceMap(PetTypeService petTypeService, PetService petService) {
		this.petTypeService = petTypeService;
		this.petService = petService;
	}

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
		if (object != null) {
			if (object.getPets() != null) {
				object.getPets().forEach(pet -> {
					if (pet.getType() != null) {
						if (pet.getType().getId() == null) {
							pet.setType(petTypeService.save(pet.getType()));
						}
					} else {
						throw new RuntimeException("Pet type is required");
					}
					if(pet.getId() == null) {
						Pet savedPet = petService.save(pet);
						pet.setId(savedPet.getId());
					}
				});
			}
		}
		return super.save(object);
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
