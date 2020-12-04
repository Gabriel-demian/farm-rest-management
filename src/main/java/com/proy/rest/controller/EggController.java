package com.proy.rest.controller;

import java.util.Collection;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
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

import com.proy.rest.dto.EggDto;
import com.proy.rest.dto.mapper.EggMapper;
import com.proy.rest.entity.Egg;
import com.proy.rest.entity.Farm;
import com.proy.rest.services.EggService;
import com.proy.rest.services.FarmService;

@RestController
@RequestMapping("/api/eggs")
@CrossOrigin("http://localhost:3000")
public class EggController {
	
	@Autowired
	EggService eggService;
	
	@Autowired
	EggMapper eggMapper;
	
	@Autowired
	private FarmService farmService;
	
	@GetMapping
	@ResponseStatus(HttpStatus.OK)
	public Collection<EggDto> getEggs(@RequestParam(required = false) Integer farmId){
		
		if(farmId != null) {
			return eggMapper.getDto(eggService.findByFarm(farmId));
		}
		
		return eggMapper.getDto(eggService.findAll());
		
	}
	
	
//	@GetMapping(path = "/farm/{farmId}")
//	@ResponseStatus(HttpStatus.OK)
//	public Iterable<EggDto> getEggsByFarmId(@PathVariable Integer farmId){
//		
//		return eggMapper.getDto(eggService.findByFarm(farmId));
//		
//	}
	
	
	@GetMapping(path = "/{eggId}")
	@ResponseStatus(HttpStatus.FOUND)
	public ResponseEntity<EggDto> getEgg(@PathVariable Integer eggId) {

		Optional<Egg> egg = eggService.findById(eggId);
		
		if(egg.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
		return ResponseEntity.ok(eggMapper.getDto(egg.get()));
		
	}
	
	
	@PostMapping(consumes = {MediaType.APPLICATION_JSON_VALUE}, 
				produces = {MediaType.APPLICATION_JSON_VALUE} )
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<EggDto> createEgg(@RequestBody @Valid EggDto dataEgg) {
		
		
		Optional<Farm> farm = farmService.findById(dataEgg.getFarm().getId());
		
		if(farm.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
		Egg egg = eggMapper.fillEntity(new Egg(), dataEgg);
		
		egg.setFarm(farm.get());
		
		Egg eggSaved = eggService.saveOrUpdateEgg(egg);	
		
		return ResponseEntity.ok(eggMapper.getDto(eggSaved));
		
	}
	
	
	@PutMapping(path = "/{eggId}", 
			consumes = {MediaType.APPLICATION_JSON_VALUE}, 
			produces = {MediaType.APPLICATION_JSON_VALUE} )
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<EggDto> updateEgg(@PathVariable Integer eggId, @RequestBody EggDto updatedEgg) {
		
		Optional<Egg> egg = eggService.findById(eggId);
		
		if(egg.isPresent()) {
			
			return ResponseEntity.ok(eggMapper.getDto(eggService.saveOrUpdateEgg(eggMapper.fillEntity(egg.get(), updatedEgg))));
		}
		
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		
	}
	
	
	@DeleteMapping(path = "/{eggId}")
	public void deleteEgg(@PathVariable Integer eggId) {
		
			eggService.deleteById(eggId);
			
	}

}
