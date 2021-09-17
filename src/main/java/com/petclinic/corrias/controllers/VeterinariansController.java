package com.petclinic.corrias.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.petclinic.corrias.services.VetService;

@Controller
public class VeterinariansController {
	
	private final VetService vetService;
	
	public VeterinariansController(VetService vetService) {
		this.vetService = vetService;
	}


	@RequestMapping({"/vets", "/vets/index", "/vets/index.html"})
	public String listVeterinarians(Model model) {
		model.addAttribute("vets", vetService.findAll());
		return "vets/index.html";
	}
	
}
