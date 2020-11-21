package com.proy.rest.dto.mapper;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.stereotype.Component;

import com.proy.rest.dto.EggDto;
import com.proy.rest.entity.Egg;

@Component
public class EggMapper implements Mapper<Egg, EggDto> {

	@Override
	public EggDto getDto(Egg entity) {
		
		EggDto dto = new EggDto();
		
		dto.setEggId(entity.getEggId());
		dto.setFarm(entity.getFarm());
		dto.setBirthDate(entity.getBirthDate());
		dto.setExpirationDate(entity.getExpirationDate());
		
		return dto;
	}

	@Override
	public Egg fillEntity(Egg entity, EggDto dto) {
		
		entity.setEggId(dto.getEggId());
		entity.setFarm(dto.getFarm());
		entity.setBirthDate(dto.getBirthDate());
		entity.setExpirationDate(dto.getExpirationDate());
		
		return entity;
	}

	@Override
	public List<EggDto> getDto(Collection<Egg> entities) {
		
		List<EggDto> res = new ArrayList<>();
		
		for(Egg egg : entities) {
			res.add(getDto(egg));
		}
		
		return res;
	}


}
