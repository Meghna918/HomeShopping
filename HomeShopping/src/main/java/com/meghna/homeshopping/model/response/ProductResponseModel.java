package com.meghna.homeshopping.model.response;

public class ProductResponseModel {
	private String productId;
	private String title;
	private String description;
	private byte[] image;
	private double price;
	private String ProductGroup;
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
	

}
