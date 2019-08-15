package com.lemisa.repository;

import org.springframework.stereotype.Repository;

import com.lemisa.domain.Customer;

@Repository ("customerDao")
public class CustomerDaoImpl extends AbstractDao<Customer> implements CustomerDao{

}
