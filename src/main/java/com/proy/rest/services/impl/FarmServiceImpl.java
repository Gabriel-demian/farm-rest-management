package com.proy.rest.services.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.proy.rest.dao.FarmDAO;
import com.proy.rest.entity.Farm;
import com.proy.rest.services.FarmService;

@Service
public class FarmServiceImpl implements FarmService{
	
	@Autowired
	private FarmDAO farmDAO; 

	@Override
	public List<Farm> getFarms() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void saveFarm(Farm theFarm) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Farm getFarm(int theId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteFarm(int theId) {
		// TODO Auto-generated method stub
		
	}

	

	

}
