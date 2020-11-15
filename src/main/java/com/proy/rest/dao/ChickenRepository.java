package com.proy.rest.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.proy.rest.entity.Chicken;

public interface ChickenRepository extends JpaRepository<Chicken, Integer>{
	
	List<Chicken> findByFarmId(Integer farmId);

}
