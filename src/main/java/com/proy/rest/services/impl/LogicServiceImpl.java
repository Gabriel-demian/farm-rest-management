package com.proy.rest.services.impl;

import java.math.BigDecimal;
import java.util.Collection;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import java.time.LocalDateTime;
import com.proy.rest.dto.ChickenDto;
import com.proy.rest.dto.EggDto;
import com.proy.rest.dto.FarmDto;
import com.proy.rest.dto.mapper.ChickenMapper;
import com.proy.rest.dto.mapper.EggMapper;
import com.proy.rest.dto.mapper.FarmMapper;
import com.proy.rest.entity.Chicken;
import com.proy.rest.entity.Egg;
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
 * This service will contain all the business logic of the program.
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
	
	@Autowired
	EggMapper eggMapper;
	
	@Autowired
	ChickenMapper chickenMapper;
	
	//************************************************************************
	//*SALE LOGIC
	//************************************************************************
	
	/**
	 *  This method will contain the chicken sale logic
	 *  @param FarmDto theFarm
	 *  @param Integer farmId
	 *  @param Collection<Integer> chickenIds
	 *  @return ?? void
	 */
	@Override
	public void sellChicken(FarmDto theFarm, Integer farmId, Collection<Integer> chickenIds) {
		
		String referenceKey = "chSalePrice";
		
		incomeFarmLogic(theFarm, farmId, referenceKey);
		
		for(Integer id : chickenIds) {
			chickenService.deleteById(id);
		}
		
	}
	
	/**
	 *  This method will contain the chicken sale logic
	 *  @param FarmDto theFarm
	 *  @param Integer farmId
	 *  @param Collection<Integer> eggIds
	 *  @return void (Next update!!  will return something)
	 */
	@Override
	public void sellEgg(FarmDto theFarm, Integer farmId, Collection<Integer> eggIds) {
		
		String referenceKey = "eggSalePrice";
		
		incomeFarmLogic(theFarm, farmId, referenceKey);
		
		for(Integer id : eggIds) {
			chickenService.deleteById(id);
		}
		
	}
	
	//************************************************************************
	//*PURCHASE LOGIC
	//************************************************************************
	
	/**
	 *  This method will contain the chicken purchase logic
	 *  @param FarmDto theFarm
	 *  @param Integer farmId
	 *  @param Integer amountOfChickens
	 *  @param BigDecimal chickenPrice
	 *  @return ?? void
	 */
	@Override
	public void buyChicken(FarmDto theFarm, Integer farmId, Integer amountOfChickens, BigDecimal chickenPrice) {
		
		Optional<Farm> farm = farmService.findById(farmId);
		
		String referenceKey = "chickenExpirationDate";
		
		Optional<Reference> referencePrice = referenceService.findById(referenceKey);
		
		/**
		 * create a new chickens
		 */
		for (int i = 0; i < amountOfChickens; i++) {
			
			LocalDateTime initDate = LocalDateTime.now();
			LocalDateTime endDate = LocalDateTime.now();
			
			endDate.plusDays(Long.parseLong(referencePrice.get().getValue()));
			
			ChickenDto newChicken = new ChickenDto();
			
			newChicken.getFarm().setId(farmId);
			
			newChicken.setBirthDate(initDate);
			
			newChicken.setExpirationDate(endDate);
			
			chickenService.saveOrUpdateChicken(chickenMapper.fillEntity(new Chicken(), newChicken));
			
		}
		
		
		BigDecimal farmExpenses = theFarm.getExpenses();
		
		BigDecimal purchaseExpenses = chickenPrice.multiply(new BigDecimal(amountOfChickens));
		
		theFarm.setExpenses(farmExpenses.add(purchaseExpenses));
		
		farmService.saveOrUpdateFarm(farmMapper.fillEntity(farm.get(), theFarm));
		
	}
	
	/**
	 *  This method will contain the eggs purchase logic
	 *  @param FarmDto theFarm
	 *  @param Integer farmId
	 *  @param Integer amountOfEggs
	 *  @param BigDecimal eggPrice
	 *  @return ?? void
	 */
	public void buyEgg(FarmDto theFarm, Integer farmId, Integer amountOfEggs, BigDecimal eggPrice) {
		
		Optional<Farm> farm = farmService.findById(farmId);
		
		String referenceKey = "eggExpirationDate";
		
		Optional<Reference> referencePrice = referenceService.findById(referenceKey);
		
		/**
		 * create a new eggs
		 */
		for (int i = 0; i < amountOfEggs; i++) {
			
			LocalDateTime initDate = LocalDateTime.now();
			LocalDateTime endDate = LocalDateTime.now();
			
			endDate.plusDays(Long.parseLong(referencePrice.get().getValue()));
			
			EggDto newEgg = new EggDto();
			
			newEgg.getFarm().setId(farmId);
			
			newEgg.setBirthDate(initDate);
			
			newEgg.setExpirationDate(endDate);
			
			eggService.saveOrUpdateEgg(eggMapper.fillEntity(new Egg(), newEgg));
			
		}
		
		
		BigDecimal farmExpenses = theFarm.getExpenses();
		
		BigDecimal purchaseExpenses = eggPrice.multiply(new BigDecimal(amountOfEggs));
		
		theFarm.setExpenses(farmExpenses.add(purchaseExpenses));
		
		farmService.saveOrUpdateFarm(farmMapper.fillEntity(farm.get(), theFarm));
		
	}
	
	

	//************************************************************************
	//*REUSABLE METHODS
	//************************************************************************
	
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
