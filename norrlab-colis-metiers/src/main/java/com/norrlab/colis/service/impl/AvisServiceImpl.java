package com.norrlab.colis.service.impl;

import java.util.Collection;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.norrlab.colis.dao.entity.Avis;
import com.norrlab.colis.dao.entity.Client;
import com.norrlab.colis.dao.interfaces.AvisDAO;
import com.norrlab.colis.dao.interfaces.GenericDAO;
import com.norrlab.colis.service.interfaces.AvisService;
@Service("avisService")
public class AvisServiceImpl extends GenericServiceImpl<Avis>implements AvisService {
	
	@Autowired
	AvisDAO dao;
	@Override
	public Collection<Avis> getAvisByClient(Client clt) {
		// TODO Auto-generated method stub
		return dao.getAvisByClient(clt);
	}

	@Override
	public Collection<Avis> getAvisByDate(Date date) {
		// TODO Auto-generated method stub
		return dao.getAvisByDate(date);
	}

	@Override
	public Collection<Avis> getAvisByDescription(String text) {
		// TODO Auto-generated method stub
		return dao.getAvisByDescription(text);
	}

	@Override
	public GenericDAO<Avis> getDAO() {
		// TODO Auto-generated method stub
		return this.dao;
	}

	@Override
	public Collection<Avis> getAll() {
		// TODO Auto-generated method stub
		return dao.getAll();
	}

	
}
