package com.norrlab.colis.dao.impl;



import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

import javax.persistence.Query;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.norrlab.colis.dao.entity.Annonce;
import com.norrlab.colis.dao.entity.Avis;
import com.norrlab.colis.dao.entity.Client;
import com.norrlab.colis.dao.entity.Colis;
import com.norrlab.colis.dao.interfaces.ClientDAO;
@Repository
public class ClientDAOImpl extends GenericDAOImpl<Client>implements ClientDAO {
	
	
	
	@Override
	public Collection<Client> getByCity(String city) {
		TypedQuery<Client> rq = em.createNamedQuery(Client.NAMED_QUERY_GEt_BY_CITY, Client.class);
		rq.setParameter("x", city);
		return rq.getResultList();
	}

	@SuppressWarnings("unchecked")
	@Override
	public Collection<Client> getByCountry(String country) {
		Query rq = em.createQuery("SELECT c FROM Client  c WHERE c.country LIKE :x");
		rq.setParameter("x", "%"+country+"%");
		return rq.getResultList();
	}
 

	@Override
	public void envoyerMessage(String msg, Long id1, Long id2, Long ann_id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Collection<Client> getAll() {
		TypedQuery<Client> rq = em.createNamedQuery(Client.NAMED_QUERY_GETALL, Client.class);
		return rq.getResultList();
	}


 
	@Override
	@Transactional(propagation= Propagation.REQUIRED)
	public void sendAvis(Long from, Long to,String texte) {
		Avis av = new Avis();
		Client c1 = em.find(Client.class, from);
		Client c2 = em.find(Client.class, to);
		
		if(c1==null || c1==null)throw new RuntimeException();
		
		av.setDescription(texte);
		av.setDateAvis(new Date());
		av.setOwnerClient(c1);
		av.setDestinationClient(c2);
		
		em.merge(c1);
		em.merge(c2);
		em.persist(av);
		
	}

	@Override
	@Transactional(propagation=Propagation.REQUIRED)
	public void publierAnnonce( Long idClient,String height,
			Long weight, Double price,String cityEnd ,String cityStart,
			Date dateEnd,Date dateStart,String description) {
		
		Client cl =  em.find(Client.class, idClient);
		Annonce ann = new Annonce();
		
		if(cl==null)throw new RuntimeException("no client for this annonce");
		
		ann.setCityEnd(cityEnd);
		ann.setCityStart(cityStart);
		ann.setClientAnnonce(cl);
		ann.setDateAnnonce(new Date());
		ann.setDateEnd(dateEnd);
		ann.setDateStart(dateStart);
		ann.setDescription(description);
		
		em.persist(ann);
		
		if(height!=null && weight!=null &&price!=null){
			Colis c = creerColis(ann.getId(), height, weight, price);
			em.persist(c);
			ann.getListColis().add(c);
		}
		
		cl.getAnnoces().add(ann);
		em.merge(cl);
		
	}

	@Override
	@Transactional(propagation=Propagation.REQUIRED)
	public Colis creerColis(Long ann_id, String height, Long weight, Double price) {
		Colis colis = new Colis();
		Annonce ann = em.find(Annonce.class, ann_id);
		Collection<Colis>coll = new ArrayList<Colis>();
		if(ann==null) throw new RuntimeException("no annconce for this colis");
		colis.setAnnonce(ann);
		colis.setHeight(height);
		colis.setWeight(weight);
		colis.setPrice(price);
		coll.add(colis);
		ann.setListColis(coll);
		em.persist(colis);
		em.merge(ann);
		return colis;
	}

	@Override
	public Collection<Client> getAllCleints() {
		TypedQuery<Client> rq = em.createNamedQuery(Client.NAMED_QUERY_GETALL, Client.class);
		return rq.getResultList();
	}
	
 

 
}
