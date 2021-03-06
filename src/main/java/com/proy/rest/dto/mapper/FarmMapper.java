package com.proy.rest.dto.mapper;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.proy.rest.dto.FarmDto;
import com.proy.rest.entity.Farm;

@Component
public class FarmMapper implements Mapper<Farm, FarmDto> {

	@Autowired
	private ChickenMapper chickenMapper;
	@Autowired
	private EggMapper eggMapper;
	
	@Override
	public FarmDto getDto(Farm entity) {
		
		return getDto(entity, CANTIDAD_ESCALONES);
	}

	@Override
	public Farm fillEntity(Farm entity, FarmDto dto) {
		
		entity.setFarmName(dto.getFarmName());
		entity.setChickenBought(dto.getChickenBought());
		entity.setChickenSold(dto.getChickenSold());
		entity.setEggBought(dto.getEggBought());
		entity.setEggSold(dto.getEggSold());
		entity.setIncome(dto.getIncome());
		entity.setExpenses(dto.getExpenses());
		
		return entity;
	}

	@Override
	public List<FarmDto> getDto(Collection<Farm> entities) {
		
		return getDto(entities, CANTIDAD_ESCALONES);
		
	}

	@Override
	public FarmDto getDto(Farm entity, Integer escalones) {
		
		FarmDto dto = new FarmDto();
		
		dto.setId(entity.getId());
		dto.setFarmName(entity.getFarmName());
		dto.setChickenBought(entity.getChickenBought());
		dto.setChickenSold(entity.getChickenSold());
		dto.setEggBought(entity.getEggBought());
		dto.setEggSold(entity.getEggSold());
		dto.setIncome(entity.getIncome());
		dto.setExpenses(entity.getExpenses());
		
		if(escalones > 0) {
			dto.setChickens(chickenMapper.getDto(entity.getChickens(), escalones-1));
			dto.setEggs(eggMapper.getDto(entity.getEggs(), escalones-1));
		}
		
		return dto;
	}

	@Override
	public List<FarmDto> getDto(Collection<Farm> entities, Integer escalones) {
		
		List<FarmDto> res = new ArrayList<>();
		
		for(Farm farm : entities) {
			res.add(getDto(farm, escalones));
		}
		
		return res;
	}


}
