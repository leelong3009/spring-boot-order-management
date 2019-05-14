package com.lemisa.service;

import java.util.List;

import com.lemisa.dto.CustomerDto;

public interface CustomerService extends Service {
	List<CustomerDto> getAll();
}
