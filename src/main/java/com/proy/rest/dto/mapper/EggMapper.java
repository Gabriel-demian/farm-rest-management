package com.proy.rest.dto.mapper;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.proy.rest.dto.EggDto;
import com.proy.rest.entity.Egg;

@Component
public class EggMapper implements Mapper<Egg, EggDto> {

	@Autowired
	private FarmMapper farmMapper;
	
	@Override
	public EggDto getDto(Egg entity) {
		
		return getDto(entity, CANTIDAD_ESCALONES);
	}

	@Override
	public Egg fillEntity(Egg entity, EggDto dto) {
		
		entity.setBirthDate(dto.getBirthDate());
		entity.setExpirationDate(dto.getExpirationDate());
		
		return entity;
	}

	@Override
	public List<EggDto> getDto(Collection<Egg> entities) {
		
		return getDto(entities, CANTIDAD_ESCALONES);
	}

	@Override
	public EggDto getDto(Egg entity, Integer escalones) {
		EggDto dto = new EggDto();
		
		dto.setId(entity.getId());
		dto.setBirthDate(entity.getBirthDate());
		dto.setExpirationDate(entity.getExpirationDate());
		if(escalones > 0) {
			dto.setFarm(farmMapper.getDto(entity.getFarm(),escalones-1));
		}
		
		return dto;	
	}

	@Override
	public List<EggDto> getDto(Collection<Egg> entities, Integer escalones) {
		
		List<EggDto> res = new ArrayList<>();
		
		for(Egg egg : entities) {
			res.add(getDto(egg, escalones));
		}
		
		return res;
	}


}
