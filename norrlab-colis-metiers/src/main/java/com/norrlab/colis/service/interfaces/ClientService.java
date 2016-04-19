package com.norrlab.colis.service.interfaces;

import java.util.Collection;
import java.util.Date;

import com.norrlab.colis.dao.entity.Client;
import com.norrlab.colis.dao.entity.Colis;

public interface ClientService extends GenericeService<Client> {
	
	public Collection<Client> getByCity(String city);
	
	public Collection<Client> getByCountry(String country);
	
	public void passerAnnonce();
	
	public void envoyerMessage(String msg,Long id1, Long id2, Long ann_id);
	
	public void sendAvis(Long from, Long to,String texte);
	
	public void publierAnnonce( Long idClient,String height,
			Long weight, Double price,String cityEnd ,String cityStart,
			Date dateEnd,Date dateStart,String description);
	/**
	 * 
	 * @param ann_id
	 * @param height
	 * @param weight
	 * @param price
	 * @return
	 */
	public Colis creerColis(Long ann_id,String height,Long weight, 
			Double price);
	/**
	 * 
	 * @return
	 */
	public Collection<Client> getAllCleints();
}
