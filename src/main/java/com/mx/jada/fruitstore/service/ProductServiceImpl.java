package com.mx.jada.fruitstore.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mx.jada.fruitstore.dao.IProductDAO;
import com.mx.jada.fruitstore.products.entity.Detail;
import com.mx.jada.fruitstore.products.entity.ProductDTO;

@Service
public class ProductServiceImpl implements ProductService{

	@Autowired
	private IProductDAO productDao;
	
	
	@Override
	@Transactional(readOnly = true )
	public List<ProductDTO> findAll() {
		
		return (List<ProductDTO>) productDao.findAll();
	}


	@Override
	@Transactional
	public ProductDTO save(ProductDTO product) {
		// TODO Auto-generated method stub
		return productDao.save(product);
	}


	@Override
	public void deleteProduct(Long id) {

		productDao.deleteById(id);
		
	}

	@Override
	@Transactional(readOnly = true )
	public ProductDTO findById(Long id) {

		return productDao.findById(id).orElse(null);
	}


	@Override
	public Detail saveDetailById(Long id,Detail detal) {

		ProductDTO prod = productDao.findById(id).orElse(null);
		Detail det = new Detail();
		
		if (prod != null) {
			det.setPrice(detal.getPrice());
			det.setCreateusername("default");
			det.setCreatinit(new Date());
			
			prod.setDetail(detal);
		}
		
		return detal;
	}


}
