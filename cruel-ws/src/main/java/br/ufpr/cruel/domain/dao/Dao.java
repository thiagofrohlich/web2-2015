package br.ufpr.cruel.domain.dao;

import java.io.Serializable;
import java.util.List;

public interface Dao<T, ID extends Serializable> {

	void persist(T entity);

	void update(T entity);

	T findById(ID id);

	void delete(T entity);

	List<T> findAll();

	void deleteAll();

}