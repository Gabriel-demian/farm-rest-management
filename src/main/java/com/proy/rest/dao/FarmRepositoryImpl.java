package com.proy.rest.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.proy.rest.entity.Farm;

@Repository
public class FarmRepositoryImpl  implements FarmRepository {

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public List<Farm> getFarms() {
		
		Session currentSession = sessionFactory.getCurrentSession();
		
		Query<Farm> theQuery = currentSession.createQuery("from Farm order by lastName", Farm.class);

		List<Farm> farmList = theQuery.getResultList();
		
		
		return farmList;
	}

	@Override
	public Farm getFarm(Integer farmId) {
		
		Session currentSession = sessionFactory.getCurrentSession();
		
		Farm theFarm = currentSession.get(Farm.class, farmId);
		
		return theFarm;
	}

	@Override
	public void saveFarm(Farm theFarm) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteFarm(Integer theId) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Farm> searchFarms(String theSearchName) {
		// TODO Auto-generated method stub
		return null;
	}
	
	

}
