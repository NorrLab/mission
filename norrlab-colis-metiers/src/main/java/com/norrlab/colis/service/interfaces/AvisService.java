package com.norrlab.colis.service.interfaces;

import java.util.Collection;
import java.util.Date;

import com.norrlab.colis.dao.entity.Avis;
import com.norrlab.colis.dao.entity.Client;

public interface AvisService extends GenericeService<Avis> {
	
	public Collection<Avis> getAll();
	
	public Collection<Avis> getAvisByClient(Client clt);
	
	public Collection<Avis> getAvisByDate(Date date);
	
	public Collection<Avis> getAvisByDescription(String text);
	
}
