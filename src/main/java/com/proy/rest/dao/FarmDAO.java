package com.proy.rest.dao;

import java.util.List;

import com.proy.rest.entity.Farm;

public interface FarmDAO {
	
	public List<Farm> getFarms();

	public void saveFarm(Farm theFarm);

	public Farm getFarm(int theId);

	public void deleteFarm(int theId);

	//public List<Farm> searchFarms(String theSearchName);

}
