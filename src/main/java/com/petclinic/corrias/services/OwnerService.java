package com.petclinic.corrias.services;

import com.petclinic.corrias.model.Owner;

public interface OwnerService extends CrudService<Owner, Long>{
	
	Owner findByLastName(String lastName);

}
