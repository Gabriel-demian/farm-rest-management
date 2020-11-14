package com.proy.rest.services;

import java.util.List;

import com.proy.rest.entity.Chicken;

public interface ChickenService {

	public List<Chicken> getChickens();
	
	public List<Chicken> getChickensByFarmId(Integer farmId);
	
	public Chicken getChicken(Integer chickenId);
	
	public void saveOrUpdateChicken(Chicken theChiken);

	public void deleteChicken(Integer theId);
}
