package com.petclinic.corrias.services.map;

import java.util.Set;

import org.springframework.stereotype.Service;

import com.petclinic.corrias.model.Speciality;
import com.petclinic.corrias.model.Vet;
import com.petclinic.corrias.services.SpecialitiesService;
import com.petclinic.corrias.services.VetService;

@Service
public class VetServiceMap extends AbstractMapService<Vet, Long> implements VetService {
	
	
	private final SpecialitiesService specialitiesService;
	
	public VetServiceMap(SpecialitiesService specialitiesService) {
		this.specialitiesService = specialitiesService;
	}

	@Override
	public Set<Vet> findAll() {
		return super.findAll();
	}

	@Override
	public Vet findById(Long id) {
		return super.findById(id);
	}

	@Override
	public Vet save(Vet object) {
		if (object != null) {
			if (object.getSpecialities().size() > 0) {
					object.getSpecialities().forEach( speciality -> {
						if(speciality.getId() == null) {
							Speciality savedSpeciality = specialitiesService.save(speciality);
							speciality.setId(savedSpeciality.getId());
						}
					});
			}
		}

		return super.save(object);
	}

	@Override
	public void delete(Vet object) {
		super.delete(object);
	}

	@Override
	public void deleteById(Long id) {
		super.deleteById(id);
	}

}
