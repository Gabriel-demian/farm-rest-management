package com.proy.rest.services;

import java.util.List;

import com.proy.rest.entity.Egg;

public interface EggService {
	
	public List<Egg> getEggs();
	
	public List<Egg> getEggsByFarmId(Integer farmId);
	
	public Egg getEgg(Integer eggId);
	
	public void saveOrUpdateEgg(Egg theEgg);

	public void deleteEgg(Integer theId);

}
