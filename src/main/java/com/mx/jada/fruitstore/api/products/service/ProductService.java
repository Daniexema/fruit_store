package com.mx.jada.fruitstore.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.mx.jada.fruitstore.products.entity.ProductDTO;

public interface ProductService {
	
	public List<ProductDTO> findAll();
	
	public Page<ProductDTO> findAll(Pageable pageable );
	
	public ProductDTO save(ProductDTO product);
	
	public void deleteProduct(Long id);
	
	public ProductDTO findById(Long id);
	
	public List<ProductDTO>findByNombre(String name);

}
