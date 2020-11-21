package com.proy.rest.services;

import java.util.List;
import java.util.Optional;

import com.proy.rest.entity.Farm;


public interface FarmService {
	
	public List<Farm> findAll();
	
	public Optional<Farm> findById(Integer farmId);
	
	public Farm saveOrUpdateFarm(Farm theFarm);

	public void deleteById(Integer theId);
	
}
