package com.proy.rest.dao;

import java.util.List;

import com.proy.rest.entity.Egg;

public interface EggRepository{
	
	public List<Egg> getEggs();
	
	public Egg getEgg(Integer eggId);
	
	public void saveOrUpdateEgg(Egg theEgg);

	public void deleteEgg(Integer theId);

}
