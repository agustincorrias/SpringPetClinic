package com.petclinic.corrias.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/owners")
@Controller
public class OwnerController {
	
	@RequestMapping({"", "/", "/list", "/index", "index.html"})
	public String listOwners() {
		return "owners/index";
	}
	
}
