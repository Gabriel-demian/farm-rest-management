package com.proy.rest.services.impl;

import java.util.List;
import java.util.Optional;

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
	public List<Farm> findAll() {
		return farmRepository.findAll();
	}

	@Override
	@Transactional
	public Optional<Farm> findById(Integer farmId) {
		
		return farmRepository.findById(farmId);
	}

	@Override
	@Transactional
	public Farm save(Farm theFarm) {
		
		return farmRepository.save(theFarm);
		
	}

	@Override
	@Transactional
	public void deleteById(Integer theId) {
		farmRepository.deleteById(theId);
		
	}

}
