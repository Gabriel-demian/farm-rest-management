package com.proy.rest.services;

import java.math.BigDecimal;
import java.util.Collection;
import com.proy.rest.entity.Farm;

public interface LogicService {
	
	/**
	 *  This method will contain the chicken sale logic
	 *  @param FarmDto theFarm
	 *  @param Integer farmId
	 *  @param Collection<Integer> chickenIds
	 *  @return ?? void
	 */
	public void sellChicken(Farm theFarm, Collection<Integer> chickenIds);

	/**
	 *  This method will contain the chicken sale logic
	 *  @param FarmDto theFarm
	 *  @param Integer farmId
	 *  @param Collection<Integer> eggIds
	 *  @return void (Next update!!  will return something)
	 */
	void sellEgg(Farm theFarm, Collection<Integer> eggIds);

	/**
	 *  This method will contain the chicken purchase logic
	 *  @param FarmDto theFarm
	 *  @param Integer farmId
	 *  @param Integer amountOfChickens
	 *  @param BigDecimal chickenPrice
	 *  @return ?? void
	 */
	void buyChicken(Farm theFarm, Integer amountOfChickens, BigDecimal chickenPrice);

	/**
	 *  This method will contain the eggs purchase logic
	 *  @param FarmDto theFarm
	 *  @param Integer farmId
	 *  @param Integer amountOfEggs
	 *  @param BigDecimal eggPrice
	 *  @return ?? void
	 */
	void buyEgg(Farm theFarm, Integer amountOfEggs, BigDecimal eggPrice);
	
	
}
