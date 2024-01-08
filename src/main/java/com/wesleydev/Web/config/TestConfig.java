package com.wesleydev.Web.config;

import java.time.Instant;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.wesleydev.Web.entities.Order;
import com.wesleydev.Web.entities.User;
import com.wesleydev.Web.repositories.OrderRepository;
import com.wesleydev.Web.repositories.UserRepository;

@Configuration
@Profile ("test")

public class TestConfig  implements CommandLineRunner{
	
    @Autowired
	private UserRepository userRepository;
    @Autowired
    private OrderRepository orderRepository;
    
	@Override
	public void run(String... args) throws Exception {
		User u1 = new User(null, "Neuza ", "Neuza@gmail.com", "888888888888", "11111111"); 
		User u2 = new User(null, "Reinaldo", "Reinaldo@gmail.com", "777777777777", "222222222"); 
		User u3 = new User(null, "william", "william@gmail.com", "12121212121212121", "121212121212121"); 
		
		Order o1 = new Order(null, Instant.parse("2024-01-20T19:53:07Z"), u1); 
		Order o2 = new Order(null, Instant.parse("2024-02-21T03:42:10Z"), u2); 
		Order o3 = new Order(null, Instant.parse("2024-03-22T15:21:22Z"), u1);
		
		userRepository.saveAll(Arrays.asList(u1,u2,u3));
		orderRepository.saveAll(Arrays.asList(o1,o2,o3));
		
	}
}
