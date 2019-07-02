package com.lemisa.util;

import java.util.List;
import java.util.stream.Collectors;

import com.lemisa.domain.Product;
import com.lemisa.dto.ProductDto;

public class ProductUtil {
	
	public static List<ProductDto> toDto(List<Product> products) {
		return products.stream().map(c -> toDto(c)).collect(Collectors.toList());
	}
	
	public static ProductDto toDto(Product product) {
		ProductDto dto = new ProductDto();
		dto.setId(product.getId());
		dto.setPrice(product.getPrice());
		dto.setName(product.getName());
		return dto;
	}
}
