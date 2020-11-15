package com.proy.rest.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.proy.rest.entity.Egg;

public interface EggRepository extends JpaRepository<Egg, Integer>{
	
	List<Egg> findByFarmId(Integer farmId);

}
