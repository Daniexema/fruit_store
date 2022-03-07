package com.mx.jada.fruitstore.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mx.jada.fruitstore.dao.IProductDAO;
import com.mx.jada.fruitstore.entity.ProductDTO;

@Service
public class ProductServiceImpl implements ProductService{

	@Autowired
	private IProductDAO productDao;
	
	
	@Override
	@Transactional(readOnly = true )
	public List<ProductDTO> findAll() {
		
		return (List<ProductDTO>) productDao.findAll();
	}

}
