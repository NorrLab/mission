package com.norrlab.colis.service.interfaces;

import java.util.Collection;

public interface GenericeService<T> {
	
	public T create(T t );
	
	public T update(T t );
	
	public T getById(Object id );

	public void delete(Integer id);
	
	public Collection<T> getAll();

}
