package br.unitins.noticias.dao;

import java.io.Serializable;

public interface DAO<T> extends Serializable {
	T create(T obj);
	void update(T obj);
	void delete(T obj);
	T findById(Integer id);
}
