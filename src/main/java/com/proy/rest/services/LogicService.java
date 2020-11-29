package com.proy.rest.services;

import java.math.BigDecimal;
import java.util.Collection;

import com.proy.rest.dto.FarmDto;

public interface LogicService {
	
	/**
	 *  This method will contain the chicken sale logic
	 *  @param FarmDto theFarm
	 *  @param Integer farmId
	 *  @param Collection<Integer> chickenIds
	 *  @return ?? void
	 */
	public void sellChicken(FarmDto theFarm, Integer farmId, Collection<Integer> chickenIds);

	/**
	 *  This method will contain the chicken sale logic
	 *  @param FarmDto theFarm
	 *  @param Integer farmId
	 *  @param Collection<Integer> eggIds
	 *  @return void (Next update!!  will return something)
	 */
	void sellEgg(FarmDto theFarm, Integer farmId, Collection<Integer> eggIds);

	/**
	 *  This method will contain the chicken purchase logic
	 *  @param FarmDto theFarm
	 *  @param Integer farmId
	 *  @param Integer amountOfChickens
	 *  @param BigDecimal chickenPrice
	 *  @return ?? void
	 */
	void buyChicken(FarmDto theFarm, Integer farmId, Integer amountOfChickens, BigDecimal chickenPrice);
	
	
}
