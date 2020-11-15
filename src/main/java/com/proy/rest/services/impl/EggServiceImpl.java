package com.proy.rest.services.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.proy.rest.dao.EggRepository;
import com.proy.rest.entity.Egg;
import com.proy.rest.services.EggService;

public class EggServiceImpl implements EggService {
	
	@Autowired
	private EggRepository eggRepository;

	@Override
	@Transactional
	public List<Egg> findAll() {
		
		return eggRepository.findAll();
		
	}

	
	@Override
	@Transactional
	public List<Egg> findByFarmId(Integer farmId) {
		
		return eggRepository.findByFarmId(farmId);
		
	}

	
	@Override
	@Transactional
	public Optional<Egg> findById(Integer eggId) {
		
		return eggRepository.findById(eggId);
		
	}

	
	@Override
	@Transactional
	public Egg saveOrUpdateEgg(Egg theEgg) {
		
		return eggRepository.save(theEgg);
		
	}

	
	@Override
	@Transactional
	public void deleteById(Integer theId) {
		
		eggRepository.deleteById(theId);
		
	}

}
