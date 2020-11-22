package com.proy.rest.dto.mapper;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.proy.rest.dto.ChickenDto;
import com.proy.rest.entity.Chicken;

@Component
public class ChickenMapper implements Mapper<Chicken, ChickenDto> {

	@Autowired
	private FarmMapper farmMapper;
	
	@Override
	public ChickenDto getDto(Chicken entity) {
		
		return getDto(entity, CANTIDAD_ESCALONES);
		
	}

	@Override
	public Chicken fillEntity(Chicken entity, ChickenDto dto) {
		
		entity.setBirthDate(dto.getBirthDate());
		entity.setExpirationDate(dto.getExpirationDate());
		
		return entity;
	}

	@Override
	public List<ChickenDto> getDto(Collection<Chicken> entities) {
		
		return getDto(entities, CANTIDAD_ESCALONES);
		
	}

	@Override
	public ChickenDto getDto(Chicken entity, Integer escalones) {
		

		ChickenDto dto = new ChickenDto();
		
		dto.setId(entity.getId());
		dto.setBirthDate(entity.getBirthDate());
		dto.setExpirationDate(entity.getExpirationDate());
		/**
		 * 
		 */
		if(escalones > 0) {
			dto.setFarm(farmMapper.getDto(entity.getFarm(), escalones-1));
		}
		
		return dto;
	}

	@Override
	public List<ChickenDto> getDto(Collection<Chicken> entities, Integer escalones) {
		
		List<ChickenDto> res = new ArrayList<>();
		
		for(Chicken chicken : entities) {
			res.add(getDto(chicken, escalones));
		}
		
		return res;
	}


}
