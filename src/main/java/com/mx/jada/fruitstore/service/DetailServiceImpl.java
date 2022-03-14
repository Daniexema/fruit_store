package com.mx.jada.fruitstore.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mx.jada.fruitstore.product.dao.DetailDAO;
import com.mx.jada.fruitstore.products.entity.Detail;


@Service
public class DetailServiceImpl implements DetailService{

	@Autowired
	DetailDAO detailDao;
	
	
	@Override
	@Transactional
	public Detail saveDetail(Detail detail) {

		return detailDao.save(detail);
	}

}
