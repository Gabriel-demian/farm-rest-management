package com.proy.rest.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.proy.rest.entity.Egg;

@Repository
public interface EggRepository extends JpaRepository<Egg, Integer>{
	
	List<Egg> findByFarm(Integer farm);

}
