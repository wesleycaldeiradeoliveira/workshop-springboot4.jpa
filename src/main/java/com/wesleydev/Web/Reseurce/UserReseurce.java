package com.wesleydev.Web.Reseurce;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wesleydev.Web.entities.User;

@RestController
@RequestMapping(value="/users")
public class UserReseurce {
@GetMapping
	public ResponseEntity<User> findAll(){
		User u = new User(10l, "wesley", "wesgmail.com", "9999999", "9090");
		return ResponseEntity.ok().body(u);
	}
}
