package com.m2i.exo.services;

import java.util.List;

public interface GenericService <T>{

	public List<T> getAll();
	
	public T getById(Long id);
	
	public T save(T entity);
	
	public void save(T[] entity);
	
	public T updateById( T entity);
	
	public void deleteByID(Long id);

	public void deleteAll();
}
