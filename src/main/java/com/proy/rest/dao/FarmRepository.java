package com.proy.rest.dao;

import java.util.List;

import com.proy.rest.entity.Farm;

public interface FarmRepository{
	
	public List<Farm> getFarms();
	
	public Farm getFarm(Integer farmId);
	
	public void saveOrUpdateFarm(Farm theFarm);

	public void deleteFarm(Integer theId);

	public List<Farm> searchFarms(String theSearchName);
}
