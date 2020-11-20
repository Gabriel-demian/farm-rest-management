package com.proy.rest.dto.mapper;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.stereotype.Component;

import com.proy.rest.dto.ChickenDto;
import com.proy.rest.entity.Chicken;

@Component
public class ChickenMapper implements Mapper<Chicken, ChickenDto> {

	@Override
	public ChickenDto getDto(Chicken entity) {
		
		ChickenDto dto = new ChickenDto();
		
		dto.setChickenId(entity.getChickenId());
		dto.setFarm(entity.getFarm());
		dto.setBirthDate(entity.getBirthDate());
		dto.setExpirationDate(entity.getExpirationDate());
		
		return dto;
	}

	@Override
	public Chicken fillEntity(Chicken entity, ChickenDto dto) {
		
		entity.setChickenId(dto.getChickenId());
		entity.setFarm(dto.getFarm());
		entity.setBirthDate(dto.getBirthDate());
		entity.setExpirationDate(dto.getExpirationDate());
		
		return entity;
	}

	@Override
	public List<ChickenDto> getDto(Collection<Chicken> entities) {
		
		List<ChickenDto> res = new ArrayList<>();
		
		for(Chicken chicken : entities) {
			res.add(getDto(chicken));
		}
		
		return res;
	}


}
