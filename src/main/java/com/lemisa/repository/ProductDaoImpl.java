package com.lemisa.repository;

import org.springframework.stereotype.Repository;

import com.lemisa.domain.Product;

@Repository("productDao")
public class ProductDaoImpl extends AbstractDao<Product> implements ProductDao{

}
