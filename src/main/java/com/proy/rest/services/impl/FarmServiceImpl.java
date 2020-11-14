package com.proy.rest.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.proy.rest.dao.FarmRepository;
import com.proy.rest.entity.Farm;
import com.proy.rest.services.FarmService;

@Service
public class FarmServiceImpl implements FarmService{
	
	@Autowired
	private FarmRepository farmRepository;

	@Override
	@Transactional
	public List<Farm> getFarms() {
		return farmRepository.getFarms();
	}

	@Override
	@Transactional
	public Farm getFarm(Integer farmId) {
		return farmRepository.getFarm(farmId);
	}

	@Override
	@Transactional
	public void saveOrUpdateFarm(Farm theFarm) {
		farmRepository.saveOrUpdateFarm(theFarm);
		
	}

	@Override
	@Transactional
	public void deleteFarm(Integer theId) {
		farmRepository.deleteFarm(theId);
		
	}

	@Override
	@Transactional
	public List<Farm> searchFarms(String theSearchName) {
		return farmRepository.searchFarms(theSearchName);
	}


}
