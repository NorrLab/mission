package com.norrlab.colis.dao.impl;

import java.util.Collection;
import java.util.Date;

import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.norrlab.colis.dao.entity.Avis;
import com.norrlab.colis.dao.entity.Client;
import com.norrlab.colis.dao.interfaces.AvisDAO;
@Repository
public class AvisDAOImpl extends GenericDAOImpl<Avis>implements AvisDAO {

	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public Avis create(Avis t) {
		em.persist(t);
		return t;
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public Avis update(Avis t) {
		em.merge(t);
		return t;
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public void delete(Integer t) {
		em.remove(t);

	}

	 
	
	public Collection<Avis> getAll() {
		TypedQuery<Avis> rq = em.createNamedQuery(Avis.GET_ALL,Avis.class);
		
		return rq.getResultList();
	}
	

	@Override
	public Collection<Avis> getAvisByDate(Date date) {
		TypedQuery<Avis> rq = em.createNamedQuery(Avis.GET_ALL,Avis.class);
		
		return rq.getResultList();
	}

	@Override
	public Collection<Avis> getAvisByDescription(String text) {
		TypedQuery<Avis> rq = em.createNamedQuery(Avis.GET_BY_DESCRIPTION,Avis.class);
		rq.setParameter("y", "%"+text+"%");
		return rq.getResultList();
	}

	@Override
	public Collection<Avis> getAvisByClient(Client clt) {
		TypedQuery<Avis> rq = em.createNamedQuery(Avis.GET_BY_CLIENT,Avis.class);
		rq.setParameter("x", clt.getId());
		return rq.getResultList();
	}

	

}
