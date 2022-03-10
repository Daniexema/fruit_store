package com.mx.jada.fruitstore.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.mx.jada.fruitstore.products.entity.ProductDTO;
import com.mx.jada.fruitstore.service.ProductService;

@CrossOrigin(origins = {"http://localhost:4200"})
@RestController
@RequestMapping("/api")
public class ProductRestController {
	
	@Autowired
	ProductService proService;
	
	
	@GetMapping("/products")
	public List<ProductDTO> products(){
		
		return proService.findAll();
	}
	
@GetMapping("/products/{id}")
public ProductDTO show(@PathVariable Long id) {
	
	return proService.findById(id);
	
}
	@PostMapping("/products")
	@ResponseStatus(code = HttpStatus.CREATED)
	public ProductDTO create(@RequestBody ProductDTO product) {
		
		return proService.save(product);
				
	}
	
	@PutMapping("/products/{id}")
	@ResponseStatus(code = HttpStatus.CREATED)
	public ProductDTO upDate(@RequestBody ProductDTO product,@PathVariable Long id) {
		
		ProductDTO actual = proService.findById(id);
		actual.setDescri(product.getDescri());
		actual.setName(product.getName());
		actual.setCreateusername("default");
		
		return proService.save(actual);
		
	}
	
	
	@DeleteMapping("/products/{id}")
	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	public void delete(@PathVariable Long id) {
		
		proService.deleteProduct(id);
	}

}
