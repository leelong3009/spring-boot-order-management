package com.aus.ecommerce.controller;


import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.aus.ecommerce.object.CustomerDto;

@RestController
@EnableAutoConfiguration
public class CustomerController {

	@RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE, path="/api/customers")
	public ResponseEntity<List<CustomerDto>> search() {
		List<CustomerDto> customers = new ArrayList<CustomerDto>();
		customers.add(new CustomerDto(1, "A"));
		customers.add(new CustomerDto(2, "ADDD"));
		customers.add(new CustomerDto(3, "AA"));
		customers.add(new CustomerDto(4, "A1"));
		customers.add(new CustomerDto(5, "ABC"));
		customers.add(new CustomerDto(6, "AAA"));
		return new ResponseEntity<List<CustomerDto>>(customers, HttpStatus.OK);
	}
}
