package com.wesleydev.Web.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.wesleydev.Web.entities.OrderItem;

public interface OrderItemRepository extends JpaRepository<OrderItem, Long>{

}
