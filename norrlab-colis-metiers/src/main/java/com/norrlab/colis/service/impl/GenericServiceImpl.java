package com.norrlab.colis.service.impl;

import com.norrlab.colis.dao.interfaces.GenericDAO;
import com.norrlab.colis.service.interfaces.GenericeService;

public abstract class GenericServiceImpl<T> implements GenericeService<T> {
	
	
	
	public GenericServiceImpl() {
		super();

	}

	@Override
	public T create(T t) {
		// TODO Auto-generated method stub
		return getDAO().create(t);
	}

	@Override
	public T update(T t) {
		
		return getDAO().update(t);
	}

	@Override
	public void delete(Integer t) {
		getDAO().delete(t);

	}

	@Override
	public T getById(Object id) {
		// TODO Auto-generated method stub
		return getDAO().getById(id);
	}

 
	public abstract GenericDAO<T> getDAO();
}
