package com.proy.rest.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.proy.rest.entity.Reference;

public interface ReferenceRepository extends JpaRepository<Reference, String>{
	

}
