package com.wesleydev.Web.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wesleydev.Web.entities.Order;
import com.wesleydev.Web.repositories.OrderRepository;

@Service
public class OrderService {
	@Autowired
	private OrderRepository repository;

	public List<Order> FindALL() {
		return repository.findAll();
	}

	public Order findById(long id) {

		Optional<Order> obj = repository.findById(id);
		return obj.get();
	}
}
