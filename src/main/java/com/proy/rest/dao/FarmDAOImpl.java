package com.proy.rest.dao;

import java.util.List;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.proy.rest.entity.Farm;

@Repository
public class FarmDAOImpl implements FarmDAO{

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public List<Farm> getFarms() {
		
		// obtener la sesión actual de hibernate
		Session currentSession = sessionFactory.getCurrentSession();

		// crear query ordenada por nombre
		Query<Farm> theQuery = currentSession.createQuery("from Farm order by farm_name", Farm.class);

		// ejecutar query y objeter la lista de resultados
		List<Farm> farms = theQuery.getResultList();

		return farms;
	}

	@Override
	public void saveFarm(Farm theFarm) {
		
		Session currentSession = sessionFactory.getCurrentSession();

		currentSession.saveOrUpdate(theFarm);
	}

	@Override
	public Farm getFarm(int theId) {
		Session currentSession = sessionFactory.getCurrentSession();

		// obtener/leer de la DB usando la key
		Farm theFarm = currentSession.get(Farm.class, theId);

		return theFarm;
	}

	@Override
	public void deleteFarm(int theId) {
		
		Session currentSession = sessionFactory.getCurrentSession();
		
		Query theQuery = currentSession.createQuery("delete from Farm where id=:farmId");

		theQuery.setParameter("farmId", theId); // setea la variable id=:farmId en la query

		theQuery.executeUpdate();
		
	}
	
	

}
