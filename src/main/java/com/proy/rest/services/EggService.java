package com.proy.rest.services;

import java.util.List;
import java.util.Optional;

import com.proy.rest.entity.Egg;

public interface EggService {
	
	public List<Egg> findAll();
	
	public Optional<Egg> findById(Integer eggId);
	
	public List<Egg> findByFarmId(Integer farmId);
	
	public Egg saveOrUpdateEgg(Egg theEgg);

	public void deleteById(Integer theId);

}
