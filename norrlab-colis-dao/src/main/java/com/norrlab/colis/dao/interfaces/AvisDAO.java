package com.norrlab.colis.dao.interfaces;

import java.util.Collection;
import java.util.Date;

import com.norrlab.colis.dao.entity.Avis;
import com.norrlab.colis.dao.entity.Client;

public interface AvisDAO extends GenericDAO<Avis> {
	
	public Collection<Avis> getAvisByClient(Client clt);
	
	public Collection<Avis> getAvisByDate(Date date);
	
	public Collection<Avis> getAvisByDescription(String text);
	
	public Collection<Avis> getAll();
	
	
}
