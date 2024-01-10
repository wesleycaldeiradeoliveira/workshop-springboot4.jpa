package com.wesleydev.Web.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wesleydev.Web.entities.Product;
import com.wesleydev.Web.repositories.ProductRepository;

@Service
public class ProductService {
	@Autowired
	private ProductRepository repository;

	public List<Product> FindALL() {
		return repository.findAll();
	}

	public Product findById(long id) {

Optional<Product> obj = repository.findById(id);
return obj.get(); 
}
}
