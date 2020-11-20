package com.proy.rest.dto.mapper;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.stereotype.Component;

import com.proy.rest.dto.FarmDto;
import com.proy.rest.entity.Farm;

@Component
public class FarmMapper implements Mapper<Farm, FarmDto> {

	@Override
	public FarmDto getDto(Farm entity) {
		
		FarmDto dto = new FarmDto();
		
		dto.setFarmId(entity.getFarmId());
		dto.setFarmName(entity.getFarmName());
		dto.setChickenBought(entity.getChickenBought());
		dto.setChickenSold(entity.getChickenSold());
		dto.setEggBought(entity.getEggBought());
		dto.setEggSold(entity.getEggSold());
		dto.setIncome(entity.getIncome());
		dto.setExpenses(entity.getExpenses());
		
		return dto;
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
		
		List<FarmDto> res = new ArrayList<>();
		
		for(Farm farm : entities) {
			res.add(getDto(farm));
		}
		
		return res;
	}


}
