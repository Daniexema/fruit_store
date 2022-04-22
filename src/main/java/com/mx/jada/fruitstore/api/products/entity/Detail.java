package com.mx.jada.fruitstore.products.entity;

import java.io.Serializable;
import java.util.Date;


import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.PrePersist;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
public class Detail implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private double price;
	
	private int exist;
	
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "yyyy-MM-dd hh:mm:ss")
	private Date creatinit; 
	
	private String createusername;
	
	@JoinColumn(name="products_id")
	@OneToOne(fetch = FetchType.EAGER,cascade = CascadeType.ALL,mappedBy = "detail")
	@JsonBackReference
	private ProductDTO products;
	
	
	@PrePersist
	public void prePersist() {
		creatinit=new Date();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getExist() {
		return exist;
	}

	public void setExist(int exist) {
		this.exist = exist;
	}

	public Date getCreatinit() {
		return creatinit;
	}

	public void setCreatinit(Date creatinit) {
		this.creatinit = creatinit;
	}

	public String getCreateusername() {
		return createusername;
	}

	public void setCreateusername(String createusername) {
		this.createusername = createusername;
	}

	public ProductDTO getProducts() {
		return products;
	}

	public void setProducts(ProductDTO products) {
		this.products = products;
	}
	
	
	
}
