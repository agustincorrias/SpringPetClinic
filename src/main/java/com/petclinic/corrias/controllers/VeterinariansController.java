package com.petclinic.corrias.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class VeterinariansController {

	@RequestMapping({"/vets", "/vets/index", "/vets/index.html"})
	public String listVeterinarians() {
		return "vets/index.html";
	}
	
}
