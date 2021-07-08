package com.meghna.homeshopping.entity;
import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity(name="product")
public class ProductEntity implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -4299454883214651365L;
	@Id
	@GeneratedValue
	private long id;
	
	
	
	@Column(nullable=false)
	private String title;
	
	@Column(nullable=false)
	private String description;
	
	
	@Column(nullable=false)
	private double price;
	
	@Column(nullable=false)
	private String productGroup;
	
	@OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "pi_id")
	@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
	private ProductImageEntity productImageEntity;
	

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

   public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	
	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getProductGroup() {
		return productGroup;
	}

	public void setProductGroup(String productGroup) {
		this.productGroup = productGroup;
	}

	public ProductImageEntity getProductImageEntity() {
		return productImageEntity;
	}

	public void setProductImageEntity(ProductImageEntity productImageEntity) {
		this.productImageEntity = productImageEntity;
	}
	

	}
	


    
	
	
	
	


