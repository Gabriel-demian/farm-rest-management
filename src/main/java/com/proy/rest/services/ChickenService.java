package com.proy.rest.services;

import java.util.List;
import java.util.Optional;

import com.proy.rest.entity.Chicken;

public interface ChickenService {

	public List<Chicken> getChickens();
	
	public List<Chicken> getChickensByFarmId(Integer farmId);
	
	public Optional<Chicken> getChicken(Integer chickenId);
	
	public void saveOrUpdateChicken(Chicken theChiken);

	public void deleteChicken(Integer theId);
}
