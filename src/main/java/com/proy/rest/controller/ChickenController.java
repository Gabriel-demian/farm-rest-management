package com.proy.rest.controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/chickens") // http://localhost:8080/farms
public class ChickenController {
	
	@GetMapping
	public String getChicken() {
		return "get Chicken was called";
	}
	
	@PostMapping
	public String createChicken() {
		return "create Chicken was called";
	}
	
	@PutMapping		
	public String updateChicken() {
		return "update Chicken was called";
	}
	
	@DeleteMapping
	public String deleteChicken() {
		return "delete Chicken was called";
	}

}
