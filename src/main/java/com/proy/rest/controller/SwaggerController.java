package com.proy.rest.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SwaggerController {
	
	@GetMapping("/swagger")
	public String goToSwagger() {
		
		return "redirect:/swagger/dist/index.html";
	}
	
	
	
	
}
