package com.meghna.homeshopping.shared.dto;
import java.awt.image.BufferedImage;
import java.io.Serializable;

import org.springframework.web.multipart.MultipartFile;

public class ProductDto implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -5640299613220609281L;
	/**
	 * 
	 */
	
	private long id;
	private String productId;
	private String title;
	private String description;
	private byte[] image;
	private BufferedImage file;
	
	private double price;
	private String ProductGroup;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getProductId() {
		return productId;
	}
	public void setProductId(String productId) {
		this.productId = productId;
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
	public byte[] getImage() {
		return image;
	}
	public void setImage(byte[] image) {
		this.image = image;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public String getProductGroup() {
		return ProductGroup;
	}
	public void setProductGroup(String productGroup) {
		ProductGroup = productGroup;
	}
	public BufferedImage getFile() {
		return file;
	}
	public void setFile(BufferedImage file) {
		this.file = file;
	}
	

}
