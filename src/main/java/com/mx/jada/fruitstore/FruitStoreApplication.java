package com.mx.jada.fruitstore;


import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class FruitStoreApplication implements CommandLineRunner {

	
	public static void main(String[] args) {
		SpringApplication.run(FruitStoreApplication.class, args);
	}
	@Override
	public void run(String... args) throws Exception {

		System.out.println("Entrando al metood run***************************");
		
	}

}
