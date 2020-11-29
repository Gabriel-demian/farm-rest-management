package com.proy.rest.services.impl;

import java.math.BigDecimal;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.proy.rest.dto.FarmDto;
import com.proy.rest.dto.mapper.FarmMapper;
import com.proy.rest.entity.Farm;
import com.proy.rest.entity.Reference;
import com.proy.rest.services.ChickenService;
import com.proy.rest.services.EggService;
import com.proy.rest.services.FarmService;
import com.proy.rest.services.LogicService;
import com.proy.rest.services.ReferenceService;
/**
 * 
 * @author Gabriel
 *	this service will contain all the business logic of the program.
 *
 */
public class LogicServiceImpl implements LogicService{
	
	@Autowired
	ReferenceService referenceService;
	
	@Autowired
	ChickenService chickenService;
	
	@Autowired
	EggService eggService;
	
	@Autowired
	FarmService farmService;
	
	@Autowired
	FarmMapper farmMapper;
	
	/**
	 *  This method will contain the chicken sale logic
	 *  @param FarmDto theFarm
	 *  @param Integer farmId
	 *  @param Integer chickenId
	 *  @return ?? void
	 */
	@Override
	public void sellChicken(FarmDto theFarm, Integer farmId, Integer chickenId) {
		
		String referenceKey = "chSalePrice";
		
		incomeFarmLogic(theFarm, farmId, referenceKey);
		
		chickenService.deleteById(chickenId);
		
	}
	
	/**
	 *  This method will contain the chicken sale logic
	 *  @param FarmDto theFarm
	 *  @param Integer farmId
	 *  @param Integer chickenId
	 *  @return void (Next update!!  will return something)
	 */
	@Override
	public void sellEgg(FarmDto theFarm, Integer farmId, Integer eggId) {
		
		String referenceKey = "eggSalePrice";
		
		incomeFarmLogic(theFarm, farmId, referenceKey);
		
		chickenService.deleteById(eggId);
		
	}

	/**
	 * This method contains the profit logic of a farm
	 * @param theFarm
	 * @param farmId
	 * @param referenceKey
	 */
	private void incomeFarmLogic(FarmDto theFarm, Integer farmId, String referenceKey) {
		Optional<Farm> farm = farmService.findById(farmId);
		
		Optional<Reference> referencePrice = referenceService.findById(referenceKey);
		
		BigDecimal farmIncome = theFarm.getIncome();
		
		BigDecimal income = new BigDecimal(referencePrice.get().getValue());
		
		theFarm.setExpenses(income.add(farmIncome));
		
		farmService.saveOrUpdateFarm(farmMapper.fillEntity(farm.get(), theFarm));
	}
	
	
	
}
