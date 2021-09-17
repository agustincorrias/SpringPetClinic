package com.petclinic.corrias.bootstrap;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.petclinic.corrias.model.Owner;
import com.petclinic.corrias.model.Vet;
import com.petclinic.corrias.services.OwnerService;
import com.petclinic.corrias.services.VetService;

@Component
public class DataLoader implements CommandLineRunner {

	private final OwnerService ownerService;
	private final VetService vetService;

	
	public DataLoader(OwnerService ownerService, VetService vetService) {
		this.ownerService = ownerService;
		this.vetService = vetService;
	}

	@Override
	public void run(String... args) throws Exception {

		Owner owner1 = new Owner();
		owner1.setFirstName("Agustin");
		owner1.setLastName("Corrias");
		owner1.setTelephone("2236686011");
		owner1.setCity("Mar del Plata");
		owner1.setAddress("Alvarado 4545");

		Owner owner2 = new Owner();
		owner2.setFirstName("Bianca");
		owner2.setLastName("Gensollen");
		owner2.setTelephone("2336167053");
		owner2.setCity("Mar del Plata");
		owner2.setAddress("Tres de febrero 2841");

		ownerService.save(owner1);
		ownerService.save(owner2);

		System.out.println("Loading owners....");

		Vet vet1 = new Vet();
		vet1.setFirstName("Marcos");
		vet1.setLastName("Salomone");

		Vet vet2 = new Vet();
		vet2.setFirstName("Francisco");
		vet2.setLastName("Mauro");

		vetService.save(vet1);
		vetService.save(vet2);

		System.out.println("Loading vets....");

	}

}
