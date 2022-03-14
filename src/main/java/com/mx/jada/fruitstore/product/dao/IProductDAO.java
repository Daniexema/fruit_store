package com.mx.jada.fruitstore.product.dao;

import org.springframework.data.repository.CrudRepository;

import com.mx.jada.fruitstore.products.entity.ProductDTO;

public interface IProductDAO extends CrudRepository<ProductDTO, Long>{



}
