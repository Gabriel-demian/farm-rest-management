package com.proy.rest.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.proy.rest.entity.Farm;
import com.proy.rest.services.FarmService;

@RestController
@RequestMapping("/farms") // http://localhost:8080/farms
public class FarmController {
	
	Map<Integer, Farm> farms;
	
	@Autowired
	FarmService farmService;
	
	@GetMapping
	public String getFarms(@RequestParam(value="page") int page,
							@RequestParam(value="limit") int limit) {	// to support pagination in future
		return "ger farm was called, page = " + page + " and limit = " + limit;
	}
	
	
	@GetMapping(path = "/{farmId}")
	public ResponseEntity<Farm> getFarm(@PathVariable Integer farmId) {

		if(farms.containsKey(farmId)) {
			return new ResponseEntity<>(farms.get(farmId), HttpStatus.OK); 
		}else {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT); 
		}
	}
	
	//TODO comentado hasta terminar los service.
//	@PostMapping(consumes = {MediaType.APPLICATION_JSON_VALUE}, 
//				produces = {MediaType.APPLICATION_JSON_VALUE} )
//	public ResponseEntity<Farm> createFarm(@RequestBody Farm dataFarm) {
//		
//		//Farm newFarm = farmService.createUser(dataFarm);
//		
//		return new ResponseEntity<Farm>(newFarm, HttpStatus.OK);
//	}
	
	
	@PutMapping(path = "/{farmId}", 
			consumes = {MediaType.APPLICATION_JSON_VALUE}, 
			produces = {MediaType.APPLICATION_JSON_VALUE} )
	public Farm updateFarm(@PathVariable Integer farmId, @RequestBody Farm updatedFarm) {
		
		Farm existingFarm = farms.get(farmId);
		existingFarm.setFarm_name(updatedFarm.getFarm_name());
		existingFarm.setChicken_bought(existingFarm.getChicken_bought());
		
		farms.put(farmId, existingFarm);
		
		return existingFarm;
		
	}
	
	
	@DeleteMapping(path = "/{farmId}")
	public ResponseEntity<Void> deleteFarm(@PathVariable Integer farmId) {
		
		farms.remove(farmId);
		
		return ResponseEntity.noContent().build();
	}
}
