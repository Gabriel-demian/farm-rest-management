package com.proy.rest.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.proy.rest.dao.ChickenRepository;
import com.proy.rest.entity.Chicken;
import com.proy.rest.entity.Egg;

@Repository
public class ChickenRepositoryImpl  implements ChickenRepository {

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public List<Chicken> getChickens() {
		
		Session currentSession = sessionFactory.getCurrentSession();
		
		Query<Chicken> theQuery = currentSession.createQuery("from chicken order by birth_date ASC", Chicken.class);

		List<Chicken> chickenList = theQuery.getResultList();
		
		return chickenList;
	}

	@Override
	public List<Chicken> getChickensByFarmId(Integer farmId) {
		
		Session currentSession = sessionFactory.getCurrentSession();
		
		Query<Chicken> theQuery = currentSession.createQuery("from chicken order by birth_date ASC where farm_id=:farmId", Chicken.class);

		theQuery.setParameter("farmId", farmId);
		
		List<Chicken> chickenList = theQuery.getResultList();
		
		return chickenList;
	}
	
	@Override
	public Chicken getChicken(Integer chickenId) {
		
		Session currentSession = sessionFactory.getCurrentSession();
		
		Chicken theChicken = currentSession.get(Chicken.class, chickenId);
		
		return theChicken;
	}

	@Override
	public void saveOrUpdateChicken(Chicken theChiken) {
		
		Session currentSession = sessionFactory.getCurrentSession();
		
		currentSession.saveOrUpdate(theChiken);
	}

	@Override
	public void deleteChicken(Integer theId) {
		
		Session currentSession = sessionFactory.getCurrentSession();
		
		Query theQuery = currentSession.createQuery("delete from chicken where chicken_id=:chickenId");
		
		theQuery.setParameter("chickenId", theId);
		
		theQuery.executeUpdate();
		
	}


	

}
