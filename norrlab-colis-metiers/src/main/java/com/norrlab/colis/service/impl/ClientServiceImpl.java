package com.norrlab.colis.service.impl;

import java.util.Collection;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.norrlab.colis.dao.entity.Client;
import com.norrlab.colis.dao.entity.Colis;
import com.norrlab.colis.dao.interfaces.ClientDAO;
import com.norrlab.colis.dao.interfaces.GenericDAO;
import com.norrlab.colis.service.interfaces.ClientService;
@Service("clientService")
public class ClientServiceImpl extends GenericServiceImpl<Client>implements ClientService {
	
	@Autowired
	protected ClientDAO dao;
	
	
	public ClientServiceImpl() {
		super();
		
	}

	@Override
	public Collection<Client> getByCity(String city) {
		 
		return dao.getByCity(city);
	}

	@Override
	public Collection<Client> getByCountry(String country) {
		// TODO Auto-generated method stub
		return dao.getByCountry(country);
	}

	@Override
	public void passerAnnonce() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void envoyerMessage(String msg, Long id1, Long id2, Long ann_id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public GenericDAO<Client> getDAO() {

		return this.dao;
	}

	
	 

	@Override
	public void sendAvis(Long from, Long to, String texte) {
		dao.sendAvis(from, to, texte);
		
	}

	@Override
	public void publierAnnonce(Long idClient, String height, Long weight, Double price, String cityEnd,
			String cityStart, Date dateEnd, Date dateStart, String description) {
			dao.publierAnnonce(idClient, height, weight, price, cityEnd, cityStart, dateEnd, dateStart, description);
		
	}

	@Override
	public Colis creerColis(Long ann_id, String height, Long weight, Double price) {
		// 
		return dao.creerColis(ann_id, height, weight, price);
	}

	@Override
	public Collection<Client> getAllCleints() {
		
		return dao.getAll();
	}

	@Override
	public Collection<Client> getAll() {
		// TODO Auto-generated method stub
		return dao.getAll();
	}

 

	
}
