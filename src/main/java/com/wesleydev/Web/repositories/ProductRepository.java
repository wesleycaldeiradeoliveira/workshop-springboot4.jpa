package com.wesleydev.Web.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.wesleydev.Web.entities.Product;

public interface ProductRepository extends JpaRepository<Product, Long>{

}
