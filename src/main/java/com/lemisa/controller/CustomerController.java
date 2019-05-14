package com.lemisa.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.lemisa.dto.CustomerDto;
import com.lemisa.service.CustomerService;

@RestController
public class CustomerController {

	@Autowired
	private CustomerService customerService;
	
	@RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE, path="/api/customers")
	public ResponseEntity<List<CustomerDto>> search() {
		List<CustomerDto> customers = customerService.getAll();

		return new ResponseEntity<List<CustomerDto>>(customers, HttpStatus.OK);
	}
}
