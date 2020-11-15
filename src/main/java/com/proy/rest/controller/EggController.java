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

import com.proy.rest.entity.Egg;
import com.proy.rest.services.EggService;

@RestController
@RequestMapping("/api/eggs")
public class EggController {
	
	@Autowired
	EggService eggService;
	
	
	@GetMapping
	@ResponseStatus(HttpStatus.OK)
	public Iterable<Egg> getAllEggs(){
		
		return eggService.findAll();
		
	}
	
	
	@GetMapping(path = "/{farmId}")
	@ResponseStatus(HttpStatus.OK)
	public Iterable<Egg> getEggsByFarmId(@PathVariable Integer farmId){
		
		return eggService.findByFarmId(farmId);
		
	}
	
	
	@GetMapping(path = "/{eggId}")
	@ResponseStatus(HttpStatus.FOUND)
	public Optional<Egg> getEgg(@PathVariable Integer eggId) {

		return eggService.findById(eggId);
		
	}
	
	
	@PostMapping(consumes = {MediaType.APPLICATION_JSON_VALUE}, 
				produces = {MediaType.APPLICATION_JSON_VALUE} )
	@ResponseStatus(HttpStatus.CREATED)
	public Egg createEgg(@RequestBody @Valid Egg dataEgg) {
		
		return eggService.saveOrUpdateEgg(dataEgg);
		
	}
	
	
	@PutMapping(path = "/{eggId}", 
			consumes = {MediaType.APPLICATION_JSON_VALUE}, 
			produces = {MediaType.APPLICATION_JSON_VALUE} )
	@ResponseStatus(HttpStatus.OK)
	public Egg updateEgg(@PathVariable Integer eggId, @RequestBody Egg updatedEgg) {
		
		return eggService.saveOrUpdateEgg(updatedEgg);
		
	}
	
	
	@DeleteMapping(path = "/{eggId}")
	public void deleteFarm(@PathVariable Integer eggId) {
		
			eggService.deleteById(eggId);
			
	}

}
