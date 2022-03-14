package com.mx.jada.fruitstore.service;

import java.util.List;

import com.mx.jada.fruitstore.products.entity.ProductDTO;

public interface ProductService {
	
	public List<ProductDTO> findAll();
	
	public ProductDTO save(ProductDTO product);
	
	public void deleteProduct(Long id);
	
	public ProductDTO findById(Long id);
	

}
