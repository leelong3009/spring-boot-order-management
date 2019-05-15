package com.lemisa.util;

import java.util.List;
import java.util.stream.Collectors;

import com.lemisa.domain.Customer;
import com.lemisa.dto.CustomerDto;

public class CustomerUtil {
	
	public static List<CustomerDto> toDto(List<Customer> customers) {
		return customers.stream().map(c -> toDto(c)).collect(Collectors.toList());
	}
	
	public static CustomerDto toDto(Customer customer) {
		CustomerDto dto = new CustomerDto();
		dto.setId(customer.getId());
		dto.setEmail(customer.getEmail());
		dto.setName(customer.getName());
		return dto;
	}
}
