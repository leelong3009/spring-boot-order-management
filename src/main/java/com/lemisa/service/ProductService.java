package com.lemisa.service;

import java.util.List;

import com.lemisa.dto.ProductDto;

public interface ProductService extends Service {
	List<ProductDto> getAll();

	ProductDto getById(Long id);
}
