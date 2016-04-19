package com.norrlab.colis.dao.interfaces;

public interface GenericDAO<T> {
	public T create(T t );
	
	public T update(T t );
	
	public void delete(Integer t );
	
	public T getById(Object id );
	
	 

}
