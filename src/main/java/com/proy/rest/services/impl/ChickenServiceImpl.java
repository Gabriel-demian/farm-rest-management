package com.proy.rest.services.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.proy.rest.dao.ChickenRepository;
import com.proy.rest.entity.Chicken;
import com.proy.rest.services.ChickenService;

@Service
public class ChickenServiceImpl implements ChickenService {
	
	@Autowired
	private ChickenRepository chickenRepository;

	@Override
	@Transactional
	public List<Chicken> findAll() {
		
		return chickenRepository.findAll();
		
	}

	
	@Override
	@Transactional
	public List<Chicken> findByFarm(Integer farmId) {
		
		return chickenRepository.findByFarm(farmId);
		
	}
	

	@Override
	@Transactional
	public Optional<Chicken> findById(Integer chickenId) {
		
		return chickenRepository.findById(chickenId);
		
	}

	
	@Override
	@Transactional
	public Chicken saveOrUpdateChicken(Chicken theChiken) {
		
		return chickenRepository.save(theChiken);
		
	}

	
	@Override
	@Transactional
	public void deleteById(Integer theId) {
		
		chickenRepository.deleteById(theId);
	
	}

}
