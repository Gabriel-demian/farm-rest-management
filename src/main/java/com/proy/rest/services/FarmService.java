package com.proy.rest.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.proy.rest.entity.Farm;

@Service
public interface FarmService {
	
	public List<Farm> getFarms();

	public void saveFarm(Farm theFarm);

	public Farm getFarm(int theId);

	public void deleteFarm(int theId);

}
