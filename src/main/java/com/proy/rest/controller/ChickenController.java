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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.proy.rest.dto.ChickenDto;
import com.proy.rest.dto.mapper.ChickenMapper;
import com.proy.rest.entity.Chicken;
import com.proy.rest.entity.Farm;
import com.proy.rest.services.ChickenService;
import com.proy.rest.services.FarmService;

@RestController
@RequestMapping("/api/chickens")
public class ChickenController {
	
	@Autowired
	private ChickenService chickenService;
	
	@Autowired
	private FarmService farmService;
	
	@Autowired
	private ChickenMapper chickenMapper;
	
	@GetMapping
	@ResponseStatus(HttpStatus.OK)
	public Collection<ChickenDto> getChickens(@RequestParam(required = false) Integer farmId){
		
		if(farmId != null) {
			return chickenMapper.getDto(chickenService.findByFarm(farmId));
		}
		
		return chickenMapper.getDto(chickenService.findAll());
	}

	
//	@GetMapping(path = "/farm/{farmId}")
//	@ResponseStatus(HttpStatus.OK)
//	public Iterable<ChickenDto> getChickensByFarmId(@PathVariable Integer farmId){
//		
//		return chickenMapper.getDto(chickenService.findByFarm(farmId));
//		
//	}
	
	
	@GetMapping(path = "/{chickenId}")
	public ResponseEntity<ChickenDto> getChicken(@PathVariable Integer chickenId) {
		
		Optional<Chicken> chicken = chickenService.findById(chickenId);
		
		if(chicken.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
		return ResponseEntity.ok(chickenMapper.getDto(chicken.get()));
		
	}
	
	
	/**
	 * @param dataChicken
	 * @return
	 */
	@PostMapping(consumes = {MediaType.APPLICATION_JSON_VALUE}, 
				produces = {MediaType.APPLICATION_JSON_VALUE} )
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<ChickenDto> createChicken(@RequestBody @Valid ChickenDto dataChicken) {
		
		Optional<Farm> farm =  farmService.findById(dataChicken.getFarm().getId());
		
		if(farm.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
		Chicken chicken = chickenMapper.fillEntity(new Chicken(), dataChicken);
		
		chicken.setFarm(farm.get());
		
		Chicken chickenSaved = chickenService.saveOrUpdateChicken(chicken);
		
		return ResponseEntity.ok(chickenMapper.getDto(chickenSaved));
		
	}
	
	
	@PutMapping(path = "/{chickenId}", 
			consumes = {MediaType.APPLICATION_JSON_VALUE}, 
			produces = {MediaType.APPLICATION_JSON_VALUE} )
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<ChickenDto> updateChicken(@PathVariable Integer chickenId, @RequestBody ChickenDto updatedChicken) {
		
		Optional<Chicken> chicken = chickenService.findById(chickenId);
		
		if(chicken.isPresent()) {
			
			return ResponseEntity.ok(chickenMapper.getDto(chickenService.saveOrUpdateChicken(chickenMapper.fillEntity(chicken.get(), updatedChicken))));
		}
		
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		
	}
	
	
	@DeleteMapping(path = "/{chickenId}")
	public void deleteChicken(@PathVariable Integer chickenId) {
		
			chickenService.deleteById(chickenId);
			
	}

}
