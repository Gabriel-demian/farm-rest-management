package com.proy.rest.controller;

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

import com.proy.rest.entity.Farm;
import com.proy.rest.services.FarmService;

@RestController
@RequestMapping("/api/farms")
public class FarmController {
	
	@Autowired
	FarmService farmService;
	
	
//	@GetMapping
//	public String getFarms(@RequestParam(value="page") int page,
//							@RequestParam(value="limit") int limit) {	// to support pagination in future
//		return "get farm was called, page = " + page + " and limit = " + limit;
//	}
	
	
	@GetMapping
	@ResponseStatus(HttpStatus.OK)
	public Iterable<Farm> getAllFarms(){
		return farmService.getFarms();
	}
	
	
	@GetMapping(path = "/{farmId}")
	@ResponseStatus(HttpStatus.FOUND)
	public Farm getFarm(@PathVariable Integer farmId) {

		return farmService.getFarm(farmId);
		
	}
	
	
	@PostMapping(consumes = {MediaType.APPLICATION_JSON_VALUE}, 
				produces = {MediaType.APPLICATION_JSON_VALUE} )
	@ResponseStatus(HttpStatus.CREATED)
	public void createFarm(@RequestBody @Valid Farm dataFarm) {
		
		farmService.saveOrUpdateFarm(dataFarm);
		
	}
	
	
	@PutMapping(path = "/{farmId}", 
			consumes = {MediaType.APPLICATION_JSON_VALUE}, 
			produces = {MediaType.APPLICATION_JSON_VALUE} )
	@ResponseStatus(HttpStatus.OK)
	public void updateFarm(@PathVariable Integer farmId, @RequestBody Farm updatedFarm) {
		
		farmService.saveOrUpdateFarm(updatedFarm);
		
	}
	
	
	@DeleteMapping(path = "/{farmId}")
	public void deleteFarm(@PathVariable Integer farmId) {
		
			farmService.deleteFarm(farmId);
			
	}
	
}
