package com.mx.jada.fruitstore.products.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.PrePersist;
import javax.persistence.Table;

import org.springframework.data.relational.core.mapping.Embedded.Nullable;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name="product")
public class ProductDTO implements Serializable {


	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(nullable = false)
	private String name;
	
	@Column(nullable = false)
	private String descri;
	@Column(nullable = false)
	private String img;
	
	private int enable;
	
	@Column(name = "create_init")
	@DateTimeFormat(pattern = "yyyy-MM-dd hh:mm:ss")
	private Date createInit;
	
	private String createusername;

	
	@OneToOne(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
	@JoinColumn(name="id_detail")
	@JsonManagedReference
	private Detail detail;
	
	
	public ProductDTO() {
		detail=(new Detail());
	}
	
	@PrePersist
	public void prePersist() {
		createInit = new Date();
		
	}
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescri() {
		return descri;
	}
	public void setDescri(String descri) {
		this.descri = descri;
	}
	public String getImg() {
		return img;
	}
	public void setImg(String img) {
		this.img = img;
	}

	public Detail getDetail() {
		return detail;
	}

	public void setDetail(Detail detail) {
		this.detail = detail;
	}

	
	public int getEnable() {
		return enable;
	}




	public void setEnable(int enable) {
		this.enable = enable;
	}




	public Date getCreateInit() {
		return createInit;
	}




	public void setCreateInit(Date createInit) {
		this.createInit = createInit;
	}




	public String getCreateusername() {
		return createusername;
	}




	public void setCreateusername(String createusername) {
		this.createusername = createusername;
	}

	public ProductDTO(Long id, String name, String descri, String img, int enable, Date createInit,
			String createusername, Detail detail) {
		super();
		this.id = id;
		this.name = name;
		this.descri = descri;
		this.img = img;
		this.enable = enable;
		this.createInit = createInit;
		this.createusername = createusername;
		this.detail = detail;
	}




	private static final long serialVersionUID = 1L;
}
