package com.mx.jada.fruitstore;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;


@SpringBootApplication
public class FruitStoreApplication implements CommandLineRunner {

	@Autowired
	BCryptPasswordEncoder encoder;
	
	public static void main(String[] args) {
		SpringApplication.run(FruitStoreApplication.class, args);
	}
	@Override
	public void run(String... args) throws Exception {

		String password="123";
		
		for (int i = 0; i < 3; i++) {
			
			String passwordEncoder = encoder.encode(password);
			System.out.println(passwordEncoder);
		}
		
	}

}
