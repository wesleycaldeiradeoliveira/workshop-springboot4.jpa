package com.wesleydev.Web.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.wesleydev.Web.entities.Category;

public interface CategoryRepository extends JpaRepository<Category, Long>{

}
