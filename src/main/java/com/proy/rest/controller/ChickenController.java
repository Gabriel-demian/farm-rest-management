package com.proy.rest.controller;

import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.proy.rest.entity.Chicken;
import com.proy.rest.services.ChickenService;

@RestController
@RequestMapping("/api/chickens")
public class ChickenController {
	
	@Autowired
	ChickenService chickenService;
	
	
	@GetMapping
	@ResponseStatus(HttpStatus.OK)
	public Iterable<Chicken> getAllChickens(){
		
		return chickenService.findAll();
		
	}
	
	
	@GetMapping(path = "/farm/{farmId}")
	@ResponseStatus(HttpStatus.OK)
	public Iterable<Chicken> getChickensByFarmId(@PathVariable Integer farmId){
		
		return chickenService.findByFarmId(farmId);
		
	}
	
	
	@GetMapping(path = "/{chickenId}")
	@ResponseStatus(HttpStatus.FOUND)
	public Optional<Chicken> getChicken(@PathVariable Integer chickenId) {

		return chickenService.findById(chickenId);
		
	}
	
	
	@PostMapping(consumes = {MediaType.APPLICATION_JSON_VALUE}, 
				produces = {MediaType.APPLICATION_JSON_VALUE} )
	@ResponseStatus(HttpStatus.CREATED)
	public Chicken createChicken(@RequestBody @Valid Chicken dataChicken) {
		
		return chickenService.saveOrUpdateChicken(dataChicken);
		
	}
	
	
	@PutMapping(path = "/{chickenId}", 
			consumes = {MediaType.APPLICATION_JSON_VALUE}, 
			produces = {MediaType.APPLICATION_JSON_VALUE} )
	@ResponseStatus(HttpStatus.OK)
	public Chicken updateChicken(@PathVariable Integer chickenId, @RequestBody Chicken updatedChicken) {
		
		return chickenService.saveOrUpdateChicken(updatedChicken);
		
	}
	
	
	@DeleteMapping(path = "/{chickenId}")
	public void deleteChicken(@PathVariable Integer chickenId) {
		
			chickenService.deleteById(chickenId);
			
	}

}
