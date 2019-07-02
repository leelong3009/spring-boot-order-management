package com.lemisa.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lemisa.domain.Product;
import com.lemisa.dto.ProductDto;
import com.lemisa.repository.ProductDao;
import com.lemisa.txn.ReadTransactional;
import com.lemisa.util.ProductUtil;

@Service("productService")
@ReadTransactional
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductDao productDao;
	
	@Override
	public List<ProductDto> getAll() {
		List<Product> products = productDao.getAll();
		return ProductUtil.toDto(products);
	}

	@Override
	public ProductDto getById(Long id) {
		return ProductUtil.toDto(productDao.getById(id));
	}
}
