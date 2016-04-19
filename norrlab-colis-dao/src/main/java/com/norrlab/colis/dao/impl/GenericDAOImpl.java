package com.norrlab.colis.dao.impl;



import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;


import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.norrlab.colis.dao.Util;
import com.norrlab.colis.dao.interfaces.GenericDAO;

public class GenericDAOImpl<T> implements GenericDAO<T> {
	
	@PersistenceContext
	EntityManager em;
	
	protected Class<T> type;
	
	@SuppressWarnings("unchecked")
	public GenericDAOImpl() {
		
		 type = (Class<T>) Util.getGenericClass(getClass());
	}

	@Override
	@Transactional(propagation=Propagation.REQUIRED)
	public T create(T t) {
		 em.persist(t);
		return t;
	}

	@Override
	@Transactional(propagation=Propagation.REQUIRED)
	public T update(T t) {
		em.merge(t);
		return t;
	}

	@Override
	@Transactional(propagation=Propagation.REQUIRED)
	public void delete(Integer t) {
		em.remove(t);
		
	}

	@Override@Transactional(propagation=Propagation.REQUIRED)
	public T getById(Object id) {
		  
		return em.find(type, 1L);//TODO heuere
	}

 

}
