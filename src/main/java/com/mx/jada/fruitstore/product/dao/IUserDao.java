package com.mx.jada.fruitstore.product.dao;

import org.springframework.data.repository.CrudRepository;

import com.mx.jada.fruitstore.products.entity.Users;


public interface IUserDao extends CrudRepository<Users, Long>{

	public Users findByUsername(String username);
}
