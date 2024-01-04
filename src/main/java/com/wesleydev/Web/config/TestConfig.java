package com.wesleydev.Web.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.wesleydev.Web.entities.User;
import com.wesleydev.Web.repositories.UserRepository;

@Configuration
@Profile ("test")

public class TestConfig  implements CommandLineRunner{
	
    @Autowired
	UserRepository userRepository;

	@Override
	public void run(String... args) throws Exception {
		User u1 = new User(null, "Neuza ", "Neuza@gmail.com", "888888888888", "11111111"); 
		User u2 = new User(null, "Reinaldo", "Reinaldo@gmail.com", "777777777777", "222222222"); 
		User u3 = new User(null, "william", "william@gmail.com", "12121212121212121", "121212121212121"); 
		userRepository.saveAll(Arrays.asList(u1,u2,u3));
		
		
	}
}
