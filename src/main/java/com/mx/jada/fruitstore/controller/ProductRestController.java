package com.mx.jada.fruitstore.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.mx.jada.fruitstore.products.entity.Detail;
import com.mx.jada.fruitstore.products.entity.ProductDTO;
import com.mx.jada.fruitstore.service.DetailService;
import com.mx.jada.fruitstore.service.ProductService;

@CrossOrigin(origins = { "http://localhost:4200" })
@RestController
@RequestMapping("/api")
public class ProductRestController {

	@Autowired
	ProductService proService;

	@Autowired
	DetailService detailService;

	@GetMapping("/products")
	public List<ProductDTO> products() {

		return proService.findAll();
	}

	@GetMapping("/products/{id}")
	public ResponseEntity<?> show(@PathVariable Long id) {
		
		ProductDTO product = null;
		
		Map<String, Object>response = new HashMap<>();
		
		try {
			product = proService.findById(id);
		} catch (DataAccessException e) {
			
			response.put("mensaje", "Error en realizar consulta");
			
			response.put("error", e.getMostSpecificCause().getMessage());
			
			return new ResponseEntity<Map<String, Object>>(response,HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		if (product==null) {
			response.put("mensaje", "No se ha encontrado el recurso solicitado");
			response.put("código", 404);
			
			return new ResponseEntity<Map<String, Object>>(response,HttpStatus.NOT_FOUND);
		}

		return new ResponseEntity<ProductDTO>(product,HttpStatus.OK);

	}

	@GetMapping(value="/loading/{name}",produces= {"application/json"})
	@ResponseBody
	public ResponseEntity<?>loadProducts(@PathVariable String name){
		
			Map<String, Object>response = new HashMap<>();
			 List<ProductDTO> loadingProducts=null;
		
		 try {
			loadingProducts =proService.findByNombre(name);
			 
		} catch (DataAccessException e) {
			
			response.put("mensaje", "Error en realizar consulta");
			response.put("error", e.getMostSpecificCause().getMessage());
			
		}
			if (loadingProducts.isEmpty()) {
				response.put("mensaje", "Parece que no encontramos lo que solicitaste");
				response.put("código", 200);
				
				return new ResponseEntity<Map<String, Object>>(response,HttpStatus.OK);
			}		 
			
			return new ResponseEntity<List<ProductDTO>>(loadingProducts,HttpStatus.OK); 
			
	}
	

	@PostMapping("/products")
	public ResponseEntity<?> create(@RequestBody ProductDTO product) {

		
		ProductDTO actual = new ProductDTO();
		Detail detailActual = new Detail();
		
		Map<String, Object>response = new HashMap<>();
		
		try {
			
				detailActual = detailService.saveDetail(product.getDetail());
		
				actual = proService.save(product);
			
		} catch (DataAccessException e) {

			response.put("mensaje", "Error en realizar insert");
			
			response.put("error", e.getMostSpecificCause().getMessage());
			
			return new ResponseEntity<Map<String, Object>>(response,HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		
		response.put("mensaje", "Producto creado correctamente");
		
		response.put("error", " ");
		
		response.put("producto", actual);
		
		
		return new ResponseEntity<Map<String, Object>>(response,HttpStatus.CREATED);

	}
	
	

	@PutMapping("/products/{id}")
	@ResponseStatus(code = HttpStatus.CREATED)
	public ProductDTO upDate(@RequestBody ProductDTO product, @PathVariable Long id) {

		ProductDTO actual = proService.findById(id);
				
		Detail detailActual = product.getDetail();
		
		actual=product;
		
		
		detailService.saveDetail(detailActual);
		
		return proService.save(actual);

	}

	@DeleteMapping("/products/{id}")
	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	public void delete(@PathVariable Long id) {

		proService.deleteProduct(id);
	}

	


}
