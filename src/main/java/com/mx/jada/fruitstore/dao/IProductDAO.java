package com.mx.jada.fruitstore.dao;

import org.springframework.data.repository.CrudRepository;

import com.mx.jada.fruitstore.entity.ProductDTO;

public interface IProductDAO extends CrudRepository<ProductDTO, Long> {
	
	

}
