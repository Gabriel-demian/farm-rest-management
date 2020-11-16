package com.proy.rest.services.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.proy.rest.dao.ReferenceRepository;
import com.proy.rest.entity.Reference;
import com.proy.rest.services.ReferenceService;

@Service
public class ReferenceServiceImpl implements ReferenceService{
	
	@Autowired
	ReferenceRepository referenceRepository;

	@Override
	public List<Reference> findAll() {
		return referenceRepository.findAll();
	}

	@Override
	public Optional<Reference> findById(String key) {
		return referenceRepository.findById(key);
	}

}
