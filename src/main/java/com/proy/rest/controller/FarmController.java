package com.proy.rest.controller;

import java.util.Collection;
import java.util.Optional;

import javax.validation.Valid;

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
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.proy.rest.dto.FarmDto;
import com.proy.rest.dto.mapper.FarmMapper;
import com.proy.rest.entity.Farm;
import com.proy.rest.services.FarmService;

@RestController
@RequestMapping("/api/farms")
public class FarmController {
	
	@Autowired
	private FarmService farmService;
	
	@Autowired
	private FarmMapper farmMapper;
	
//	@GetMapping
//	public String getFarms(@RequestParam(value="page") int page,
//							@RequestParam(value="limit") int limit) {	// to support pagination in future
//		return "get farm was called, page = " + page + " and limit = " + limit;
//	}
	
	
	@GetMapping
	@ResponseStatus(HttpStatus.OK)
	public Collection<FarmDto> getAllFarms(){
		
		return farmMapper.getDto(farmService.findAll());
	}
	
	
	@GetMapping(path = "/{farmId}")
	public ResponseEntity<FarmDto> getFarm(@PathVariable Integer farmId) {
		
		Optional<Farm> farm =  farmService.findById(farmId);
		
		if(farm.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
		return ResponseEntity.ok(farmMapper.getDto(farm.get())) ;
		
	}
	
	
	@PostMapping(consumes = {MediaType.APPLICATION_JSON_VALUE}, 
				produces = {MediaType.APPLICATION_JSON_VALUE} )
	@ResponseStatus(HttpStatus.CREATED)
	public FarmDto createFarm(@RequestBody @Valid FarmDto dataFarm) {
		
		return farmMapper.getDto(farmService.save(farmMapper.fillEntity(new Farm() , dataFarm)));
		
	}
	
	
	@PutMapping(path = "/{farmId}", 
			consumes = {MediaType.APPLICATION_JSON_VALUE}, 
			produces = {MediaType.APPLICATION_JSON_VALUE} )
	public ResponseEntity<FarmDto> updateFarm(@PathVariable Integer farmId, @RequestBody FarmDto updatedFarm) {
		
		Optional<Farm> farm = farmService.findById(farmId);
		
		if(farm.isPresent()) {
			
			return ResponseEntity.ok(farmMapper.getDto(farmService.save(farmMapper.fillEntity(farm.get(), updatedFarm))));
			
		}
		
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		
	}
	
	
	@DeleteMapping(path = "/{farmId}")
	@ResponseStatus(HttpStatus.OK)
	public void deleteFarm(@PathVariable Integer farmId) {
		
			farmService.deleteById(farmId);
			
	}
	
}
