package com.lemisa.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lemisa.domain.Customer;
import com.lemisa.dto.CustomerDto;
import com.lemisa.repository.CustomerDao;
import com.lemisa.txn.ReadTransactional;
import com.lemisa.util.CustomerUtil;

@Service("customerService")
@ReadTransactional
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	private CustomerDao customerDao;
	
	@Override
	public List<CustomerDto> getAll() {
		List<Customer> customers = customerDao.getAll();
		return CustomerUtil.toDto(customers);
	}

	@Override
	public CustomerDto getById(Long id) {
		return CustomerUtil.toDto(customerDao.getById(id));
	}
}
