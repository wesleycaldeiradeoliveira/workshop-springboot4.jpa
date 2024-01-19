package com.wesleydev.Web.Reseurce;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wesleydev.Web.entities.Category;
import com.wesleydev.Web.services.CategoryService;

@RestController
@RequestMapping(value = "/category")
public class CategoryReseurce {
	@Autowired
	private CategoryService service;

	@GetMapping
	public ResponseEntity<List<Category>> findAll() {
		List<Category> list = service.FindALL();
		return ResponseEntity.ok().body(list);
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<Category> findById(@PathVariable long id) {
		Category obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}
}
