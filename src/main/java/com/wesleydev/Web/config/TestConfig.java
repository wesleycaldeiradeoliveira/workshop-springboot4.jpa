package com.wesleydev.Web.config;

import java.time.Instant;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.wesleydev.Web.entities.Category;
import com.wesleydev.Web.entities.Order;
import com.wesleydev.Web.entities.OrderItem;
import com.wesleydev.Web.entities.Payment;
import com.wesleydev.Web.entities.Product;
import com.wesleydev.Web.entities.User;
import com.wesleydev.Web.entities.enuns.OrderStatus;
import com.wesleydev.Web.repositories.CategoryRepository;
import com.wesleydev.Web.repositories.OrderItemRepository;
import com.wesleydev.Web.repositories.OrderRepository;
import com.wesleydev.Web.repositories.ProductRepository;
import com.wesleydev.Web.repositories.UserRepository;

@Configuration
@Profile("test")

public class TestConfig implements CommandLineRunner {

	@Autowired
	private UserRepository userRepository;
	@Autowired
	private OrderRepository orderRepository;
	@Autowired
	private CategoryRepository categoryRepository;
	@Autowired
	private ProductRepository productRepository;
	@Autowired
	private OrderItemRepository orderItemRepository;

	@Override
	public void run(String... args) throws Exception {

		Category cat1 = new Category(null, "Electronics");
		Category cat2 = new Category(null, "Books");
		Category cat3 = new Category(null, "Computers");

		Product p1 = new Product(null, "The Lord of the Rings", "Lorem ipsum dolor sit amet, consectetur.", 90.5, "");
		Product p2 = new Product(null, "Smart TV", "Nulla eu imperdiet purus. Maecenas ante.", 2190.0, "");
		Product p3 = new Product(null, "Macbook Pro", "Nam eleifend maximus tortor, at mollis.", 1250.0, "");
		Product p4 = new Product(null, "PC Gamer", "Donec aliquet odio ac rhoncus cursus.", 1200.0, "");
		Product p5 = new Product(null, "Rails for Dummies", "Cras fringilla convallis sem vel faucibus.", 100.99, "");

		p1.getCategories().add(cat2);
		p2.getCategories().add(cat1);
		p3.getCategories().add(cat3);
		p4.getCategories().add(cat3);
		p5.getCategories().add(cat2);

		User u1 = new User(null, "Neuza ", "Neuza@gmail.com", "888888888888", "11111111");
		User u2 = new User(null, "Reinaldo", "Reinaldo@gmail.com", "777777777777", "222222222");
		User u3 = new User(null, "william", "william@gmail.com", "12121212121212121", "121212121212121");

		Order o1 = new Order(null, Instant.parse("2024-01-20T19:53:07Z"), OrderStatus.PAID, u1);
		Order o2 = new Order(null, Instant.parse("2024-02-21T03:42:10Z"), OrderStatus.WAITING_PAYMENT, u2);
		Order o3 = new Order(null, Instant.parse("2024-03-22T15:21:22Z"), OrderStatus.WAITING_PAYMENT, u1);

		categoryRepository.saveAll(Arrays.asList(cat1, cat2, cat3));
		userRepository.saveAll(Arrays.asList(u1, u2, u3));
		orderRepository.saveAll(Arrays.asList(o1, o2, o3));
		productRepository.saveAll(Arrays.asList(p1, p2, p3, p4, p5));

		OrderItem oi1 = new OrderItem(o1, p1, 2, p1.getPrice());
		OrderItem oi2 = new OrderItem(o1, p3, 1, p3.getPrice());
		OrderItem oi3 = new OrderItem(o2, p3, 2, p3.getPrice());
		OrderItem oi4 = new OrderItem(o3, p5, 2, p5.getPrice());

		orderItemRepository.saveAll(Arrays.asList(oi1, oi2, oi3, oi4));
		
		Payment pay1 = new Payment(null, Instant.parse("2024-01-20T19:53:07Z"),o1);
		o1.setPayment(pay1);
		
		orderRepository.save(o1);
		
	}
}
