package com.proy.rest.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.proy.rest.dao.EggRepository;
import com.proy.rest.entity.Egg;

@Repository
public class EggRepositoryImpl  implements EggRepository {

	@Autowired
	private SessionFactory sessionFactory;
	

	@Override
	public List<Egg> getEggsByFarmId(Integer farmId) {
		
		Session currentSession = sessionFactory.getCurrentSession();
		
		Query<Egg> theQuery = currentSession.createQuery("from egg order by birth_date ASC where farm_id=:farmId", Egg.class);

		theQuery.setParameter("farmId", farmId);
		
		List<Egg> eggList = theQuery.getResultList();
		
		return eggList;
	}

	
	@Override
	public List<Egg> getEggs() {
		
		Session currentSession = sessionFactory.getCurrentSession();
		
		Query<Egg> theQuery = currentSession.createQuery("from egg order by birth_date ASC", Egg.class);

		List<Egg> eggList = theQuery.getResultList();
		
		return eggList;
	}

	@Override
	public Egg getEgg(Integer eggId) {
		
		Session currentSession = sessionFactory.getCurrentSession();
		
		Egg theEgg = currentSession.get(Egg.class, eggId);
		
		return theEgg;
	}

	@Override
	public void saveOrUpdateEgg(Egg theEgg) {
		
		Session currentSession = sessionFactory.getCurrentSession();
		
		currentSession.saveOrUpdate(theEgg);
	}

	@Override
	public void deleteEgg(Integer theId) {
		
		Session currentSession = sessionFactory.getCurrentSession();
		
		Query theQuery = currentSession.createQuery("delete from egg where egg_id=:eggId");
		
		theQuery.setParameter("eggId", theId);
		
		theQuery.executeUpdate();
		
	}

	

}
