package com.proy.rest.services.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.proy.rest.dao.ChickenRepository;
import com.proy.rest.entity.Chicken;
import com.proy.rest.services.ChickenService;

public class ChickenServiceImpl implements ChickenService {
	
	@Autowired
	private ChickenRepository chickenRepository;

	@Override
	@Transactional
	public List<Chicken> getChickens() {
		
		return chickenRepository.findAll();
		
	}

	
	@Override
	@Transactional
	public List<Chicken> getChickensByFarmId(Integer farmId) {
		
		return chickenRepository.findByFarmId(farmId);
		
	}
	

	@Override
	@Transactional
	public Optional<Chicken> getChicken(Integer chickenId) {
		
		return chickenRepository.findById(chickenId);
		
	}

	
	@Override
	@Transactional
	public void saveOrUpdateChicken(Chicken theChiken) {
		
		chickenRepository.save(theChiken);
		
	}

	
	@Override
	@Transactional
	public void deleteChicken(Integer theId) {
		
		chickenRepository.deleteById(theId);
	
	}

}
