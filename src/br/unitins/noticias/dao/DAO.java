package br.unitins.noticias.dao;

import java.io.Serializable;
import java.util.List;

public interface DAO<T> extends Serializable {
	boolean create(T obj);
	boolean update(T obj);
	boolean delete(T obj);
	T findById(Integer id);
	List<T> getALL();
}
