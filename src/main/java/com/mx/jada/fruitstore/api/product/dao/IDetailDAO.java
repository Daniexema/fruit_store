package com.mx.jada.fruitstore.product.dao;

import org.springframework.data.repository.CrudRepository;

import com.mx.jada.fruitstore.products.entity.Detail;

public interface IDetailDAO extends CrudRepository<Detail, Long>{

}
