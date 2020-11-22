package com.proy.rest.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.proy.rest.entity.Chicken;

@Repository
public interface ChickenRepository extends JpaRepository<Chicken, Integer>{
	
	List<Chicken> findByFarmId(Integer id);

}
