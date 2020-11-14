package com.proy.rest.services.impl;

import java.util.List;

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
	public List<Egg> getEggs() {
		return eggRepository.getEggs();
	}

	@Override
	@Transactional
	public List<Egg> getEggsByFarmId(Integer farmId) {
		return eggRepository.getEggsByFarmId(farmId);
	}

	@Override
	@Transactional
	public Egg getEgg(Integer eggId) {
		return eggRepository.getEgg(eggId);
	}

	@Override
	@Transactional
	public void saveOrUpdateEgg(Egg theEgg) {
		eggRepository.saveOrUpdateEgg(theEgg);
	}

	@Override
	@Transactional
	public void deleteEgg(Integer theId) {
		eggRepository.deleteEgg(theId);
	}

}
