package com.lemisa.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityNotFoundException;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import com.lemisa.util.ReflectionUtils;

public class AbstractDao<T> implements Dao<T> {
	@PersistenceContext
	private EntityManager entityManager;
	
	protected final Class<T> domainClass;
	
	protected AbstractDao() {
		this.domainClass = ReflectionUtils.resolveDomainClass(this.getClass());
	}
	
	protected CriteriaBuilder getCriteriaBuilder() {
		return entityManager.getCriteriaBuilder();
	}
	
	@Override
	public T loadById(Long id) {
		return entityManager.getReference(domainClass, id);
	}
	
	@Override
	public T getById(Long id) {
		T result = entityManager.find(domainClass, id);
		if (result == null) {
			throw new EntityNotFoundException("Entity not found for " + domainClass + " with id: " + id);
		}
		return result;
	}
	
	@Override
	public List<T> getAll() {
		CriteriaBuilder cb = getCriteriaBuilder();
		CriteriaQuery<T> cq = cb.createQuery(domainClass);
		Root<T> root = cq.from(domainClass);
		cq.select(root);
		return getResult(cq);
	}
	
	protected List<T> getResult(CriteriaQuery<T> listCQ) {
		TypedQuery<T> listQuery = entityManager.createQuery(listCQ);
		List<T> list = listQuery.getResultList();
		return list;
	}
}
