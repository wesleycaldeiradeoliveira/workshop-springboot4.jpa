package com.wesleydev.Web.Reseurce;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wesleydev.Web.entities.User;
import com.wesleydev.Web.services.UserService;

@RestController
@RequestMapping(value = "/users")
public class UserReseurce {
	@Autowired
	private UserService service;

	@GetMapping
	public ResponseEntity<List<User>> findAll() {
		List<User> list = service.FindALL();
		return ResponseEntity.ok().body(list);
	}
	@GetMapping(value = "/{id}")
	public ResponseEntity<User> findById (@PathVariable long id){
		User obj = service.findById(id);
	return ResponseEntity.ok().body(obj);
	}
}
