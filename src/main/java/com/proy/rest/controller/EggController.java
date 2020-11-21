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

import com.proy.rest.dto.ChickenDto;
import com.proy.rest.dto.EggDto;
import com.proy.rest.dto.mapper.EggMapper;
import com.proy.rest.entity.Chicken;
import com.proy.rest.entity.Egg;
import com.proy.rest.services.EggService;

@RestController
@RequestMapping("/api/eggs")
public class EggController {
	
	@Autowired
	EggService eggService;
	
	@Autowired
	EggMapper eggMapper;
	
	@GetMapping
	@ResponseStatus(HttpStatus.OK)
	public Collection<EggDto> getAllEggs(){
		
		return eggMapper.getDto(eggService.findAll());
		
	}
	
	
	@GetMapping(path = "/farm/{farmId}")
	@ResponseStatus(HttpStatus.OK)
	public Iterable<EggDto> getEggsByFarmId(@PathVariable Integer farmId){
		
		return eggMapper.getDto(eggService.findByFarmId(farmId));
		
	}
	
	
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
	public EggDto createEgg(@RequestBody @Valid EggDto dataEgg) {
		
		return eggMapper.getDto(eggService.saveOrUpdateEgg(eggMapper.fillEntity(new Egg(), dataEgg)));
		
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
