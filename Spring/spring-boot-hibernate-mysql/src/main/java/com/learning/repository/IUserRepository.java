package com.learning.repository;

import com.learning.exception.ResourceNotFoundException;

public interface IUserRepository<T> {
	public abstract void save(T t);

	public abstract T loadById(int id);
	
	public abstract boolean deleteById(int id);
	
	public abstract T update(T t) throws ResourceNotFoundException;
	
	public abstract T findByEmail(String s);
}
