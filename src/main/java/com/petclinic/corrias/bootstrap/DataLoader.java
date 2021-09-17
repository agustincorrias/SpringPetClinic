package com.petclinic.corrias.bootstrap;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.petclinic.corrias.model.Owner;
import com.petclinic.corrias.model.Pet;
import com.petclinic.corrias.model.PetType;
import com.petclinic.corrias.model.Speciality;
import com.petclinic.corrias.model.Vet;
import com.petclinic.corrias.services.OwnerService;
import com.petclinic.corrias.services.PetTypeService;
import com.petclinic.corrias.services.SpecialitiesService;
import com.petclinic.corrias.services.VetService;

@Component
public class DataLoader implements CommandLineRunner {

	private final OwnerService ownerService;
	private final VetService vetService;
	private final PetTypeService petTypeService;
	private final SpecialitiesService specialitiesService;

	public DataLoader(OwnerService ownerService, VetService vetService, PetTypeService petTypeService,
			SpecialitiesService specialitiesService) {
		this.ownerService = ownerService;
		this.vetService = vetService;
		this.petTypeService = petTypeService;
		this.specialitiesService = specialitiesService;
	}

	@Override
	public void run(String... args) throws Exception {

		loadData();

	}

	private void loadData() {
		PetType petType1 = new PetType();
		petType1.setTypeName("dog");

		PetType petType2 = new PetType();
		petType2.setTypeName("cat");

		PetType dog = petTypeService.save(petType1);
		PetType cat = petTypeService.save(petType2);

		System.out.println("Loading pet types....");

		Owner owner1 = new Owner();
		owner1.setFirstName("Agustin");
		owner1.setLastName("Corrias");
		owner1.setTelephone("2236686011");
		owner1.setCity("Mar del Plata");
		owner1.setAddress("Alvarado 4545");

		Pet kika = new Pet();
		kika.setType(dog);
		kika.setOwner(owner1);
		kika.setBirthDate(LocalDate.now());
		kika.setName("Kika");

		owner1.getPets().add(kika);

		Owner owner2 = new Owner();
		owner2.setFirstName("Bianca");
		owner2.setLastName("Gensollen");
		owner2.setTelephone("2336167053");
		owner2.setCity("Mar del Plata");
		owner2.setAddress("Tres de febrero 2841");

		Pet rosco = new Pet();
		rosco.setType(cat);
		rosco.setOwner(owner2);
		rosco.setBirthDate(LocalDate.now());
		rosco.setName("Roskito");

		owner2.getPets().add(rosco);

		ownerService.save(owner1);
		ownerService.save(owner2);

		System.out.println("Loading owners....");

		Speciality spec1 = new Speciality();
		spec1.setDescription("Radiology");

		Speciality spec2 = new Speciality();
		spec2.setDescription("Surgery");

		Speciality spec3 = new Speciality();
		spec3.setDescription("Dentistry");

		Speciality radiology = specialitiesService.save(spec1);
		Speciality surgery = specialitiesService.save(spec2);
		Speciality dentistry = specialitiesService.save(spec3);

		System.out.println("Loading specialities....");

		Vet vet1 = new Vet();
		vet1.setFirstName("Marcos");
		vet1.setLastName("Salomone");
		vet1.getSpecialities().add(radiology);
		vet1.getSpecialities().add(surgery);

		Vet vet2 = new Vet();
		vet2.setFirstName("Francisco");
		vet2.setLastName("Mauro");
		vet2.getSpecialities().add(dentistry);

		vetService.save(vet1);
		vetService.save(vet2);

		System.out.println("Loading vets....");
	}

}
