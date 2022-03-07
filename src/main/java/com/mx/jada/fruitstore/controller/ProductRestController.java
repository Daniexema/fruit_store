package com.mx.jada.fruitstore.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mx.jada.fruitstore.entity.ProductDTO;
import com.mx.jada.fruitstore.service.ProductService;

@CrossOrigin(origins = {"http://localhost:4200"})
@RestController
@RequestMapping("/api")
public class ProductRestController {
	
	@Autowired
	ProductService proService;
	
	@GetMapping("/produts")
	public List<ProductDTO> products(){
		
		return proService.findAll();
	}
	

}
