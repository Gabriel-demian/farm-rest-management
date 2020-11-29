package com.proy.rest.services;

import com.proy.rest.dto.FarmDto;

public interface LogicService {
	
	/**
	 * this method will contain the chicken sale logic
	 *  @param FarmDto theFarm
	 *  @param Integer farmId
	 *  @param Integer chickenId
	 *  @return ?? void
	 */
	public void sellChicken(FarmDto theFarm, Integer farmId, Integer chickenId);

	/**
	 * this method will contain the egg sale logic
	 *  @param FarmDto theFarm
	 *  @param Integer farmId
	 *  @param Integer eggId
	 *  @return ?? void
	 */
	void sellEgg(FarmDto theFarm, Integer farmId, Integer eggId);
	
	
}
