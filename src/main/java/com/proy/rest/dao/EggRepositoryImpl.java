package com.proy.rest.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.proy.rest.entity.Chicken;
import com.proy.rest.entity.Egg;

@Repository
public class EggRepositoryImpl  implements EggRepository {

	@Autowired
	private SessionFactory sessionFactory;
	
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
		
		Query theQuery = currentSession.createQuery("delete from egg where id=:eggId");
		
		theQuery.setParameter("eggId", theId);
		
		theQuery.executeUpdate();
		
	}

	

}
