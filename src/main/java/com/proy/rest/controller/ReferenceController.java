package com.proy.rest.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.proy.rest.entity.Reference;
import com.proy.rest.services.ReferenceService;

@RestController
@RequestMapping("/api/references")
public class ReferenceController {
	
	@Autowired
	ReferenceService referenceService;
	
	@GetMapping
	@ResponseStatus(HttpStatus.OK)
	public Iterable<Reference> getAllReferences(){
		
		return referenceService.findAll();
		
	}
	
	
	@GetMapping(path = "/{key}")
	@ResponseStatus(HttpStatus.OK)
	public Optional<Reference> getReferenceByKey(@PathVariable String key){
		
		return referenceService.findById(key);
		
	}
	
	
	
	
	
	
}
