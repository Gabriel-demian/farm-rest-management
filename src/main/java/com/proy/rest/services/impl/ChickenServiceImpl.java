package com.proy.rest.services.impl;

import java.util.List;

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
		return chickenRepository.getChickens();
	}

	@Override
	@Transactional
	public List<Chicken> getChickensByFarmId(Integer farmId) {
		return chickenRepository.getChickensByFarmId(farmId);
	}

	@Override
	@Transactional
	public Chicken getChicken(Integer chickenId) {
		return chickenRepository.getChicken(chickenId);
	}

	@Override
	@Transactional
	public void saveOrUpdateChicken(Chicken theChiken) {
		chickenRepository.saveOrUpdateChicken(theChiken);
	}

	@Override
	@Transactional
	public void deleteChicken(Integer theId) {
		chickenRepository.deleteChicken(theId);
	}

}
