package com.wesleydev.Web.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.wesleydev.Web.entities.Order;

public interface OrderRepository extends JpaRepository<Order, Long>{

}
