package com.proy.rest.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.proy.rest.entity.Farm;

@Repository
public interface FarmRepository extends JpaRepository<Farm, Integer>{
	
	List<Farm> findByFarmName(String name);
	
}
