package com.msl.mongo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.msl.mongo.domain.product.Product;
import com.msl.mongo.domain.product.ProductRepository;

@Service
public class ProductService {
	@Autowired
	ProductRepository repository;
	
	public List<Product> findByName(String name) {
		return repository.findByName(name);
	}

}
