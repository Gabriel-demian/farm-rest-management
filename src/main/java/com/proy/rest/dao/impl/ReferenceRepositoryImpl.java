package com.proy.rest.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.proy.rest.dao.ReferenceRepository;
import com.proy.rest.entity.Reference;

@Repository
public class ReferenceRepositoryImpl  implements ReferenceRepository {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public List<Reference> getReferences() {
		
		Session currentSession = sessionFactory.getCurrentSession();
		
		Query<Reference> theQuery = currentSession.createQuery("from reference ", Reference.class);

		List<Reference> referenceList = theQuery.getResultList();
		
		return referenceList;
	}
	
	
	

	

}
