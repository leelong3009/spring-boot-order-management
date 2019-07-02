package com.lemisa.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.lemisa.dto.ProductDto;
import com.lemisa.service.ProductService;

@RestController
public class ProductController {

	@Autowired
	private ProductService productService;
	
	@RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE, path="/api/products")
	public ResponseEntity<List<ProductDto>> search() {
		List<ProductDto> customers = productService.getAll();

		return new ResponseEntity<List<ProductDto>>(customers, HttpStatus.OK);
	}
	
	@RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE, path="/api/products/{id}")
	public ResponseEntity<ProductDto> getById(@PathVariable Long id) {
		return new ResponseEntity<ProductDto>(productService.getById(id), HttpStatus.OK);
	}
}
