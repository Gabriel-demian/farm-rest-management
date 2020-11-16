package com.proy.rest.services;

import java.util.List;
import java.util.Optional;

import com.proy.rest.entity.Reference;

public interface ReferenceService {

	public List<Reference> findAll();
	
	public Optional<Reference> findById(String key);
}
