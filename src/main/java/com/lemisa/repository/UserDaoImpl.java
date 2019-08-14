package com.lemisa.repository;

import java.util.Optional;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Repository;

import com.lemisa.domain.User;

@Repository("userDao")
public class UserDaoImpl extends AbstractDao<User> implements UserDao{

	@Override
	public Optional<User> findByUsername(String userName) {
		CriteriaBuilder cb = getCriteriaBuilder();
		CriteriaQuery<User> cq = cb.createQuery(domainClass);
		Root<User> root = cq.from(domainClass);
		cq.select(root);
		cq.where(cb.equal(root.get("name"), userName));
		
		return getSingleResult(cq);
	}
}
