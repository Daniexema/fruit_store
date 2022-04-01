package com.mx.jada.fruitstore.product.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.mx.jada.fruitstore.products.entity.ProductDTO;

public interface IProductDAO extends CrudRepository<ProductDTO, Long>{


	@Query("select p from ProductDTO p where p.name like %?1%")
	public List<ProductDTO>findByName(String name);

}
