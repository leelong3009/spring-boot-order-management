package com.lemisa.repository;

import java.util.List;

public interface Dao<T> {

	T loadById(Long id);

	T getById(Long id);

	List<T> getAll();

}
