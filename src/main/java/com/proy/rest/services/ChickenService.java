package com.proy.rest.services;

import java.util.List;
import java.util.Optional;

import com.proy.rest.entity.Chicken;

public interface ChickenService {

	public List<Chicken> findAll();
	
	public List<Chicken> findByFarm(Integer farmId);
	
	public Optional<Chicken> findById(Integer chickenId);
	
	public Chicken saveOrUpdateChicken(Chicken theChiken);

	public void deleteById(Integer theId);
}
