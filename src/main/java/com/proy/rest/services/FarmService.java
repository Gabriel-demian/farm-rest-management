package com.proy.rest.services;

import java.util.List;

import com.proy.rest.entity.Farm;

public interface FarmService {
	
	public List<Farm> getFarms();

	public void saveFarm(Farm theFarm);

	public Farm getFarm(int theId);

	public void deleteFarm(int theId);

}
