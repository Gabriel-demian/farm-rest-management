package com.proy.rest.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.proy.rest.dao.FarmRepository;
import com.proy.rest.entity.Farm;


@Repository
public class FarmRepositoryImpl  implements FarmRepository {


	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public List<Farm> getFarms() {
		
		Session currentSession = sessionFactory.getCurrentSession();
		
		Query<Farm> theQuery = currentSession.createQuery("from farm order by farm_name", Farm.class);

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
	public void saveOrUpdateFarm(Farm theFarm) {
		
		Session currentSession = sessionFactory.getCurrentSession();
		
		currentSession.saveOrUpdate(theFarm);
	}

	@Override
	public void deleteFarm(Integer theId) {
		
		Session currentSession = sessionFactory.getCurrentSession();
		
		Query theQuery = currentSession.createQuery("delete from farm where farm_id=:farmId");
		
		theQuery.setParameter("farmId", theId);
		
		theQuery.executeUpdate();
		
	}

	@Override
	public List<Farm> searchFarms(String theSearchName) {
		
		Session currentSession = sessionFactory.getCurrentSession();

		Query theQuery = null;
		
		if (theSearchName != null && theSearchName.trim().length() > 0) {

			
			theQuery = currentSession.createQuery(
					"from farm where lower(farmName) like :theName",
					Farm.class);
			theQuery.setParameter("theName", "%" + theSearchName.toLowerCase() + "%");

		} else {
			
			theQuery = currentSession.createQuery("from farm", Farm.class);
		}

		
		List<Farm> farms = theQuery.getResultList();
		
		return farms;
	}
	

}