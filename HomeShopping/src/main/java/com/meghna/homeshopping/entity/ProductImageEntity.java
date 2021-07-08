package com.meghna.homeshopping.entity;
import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;
@Entity(name="productImage")
public class ProductImageEntity implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -8596391251521013217L;
	@Id
	@GeneratedValue
	private long id;
	@Lob
	@Column(columnDefinition = "MEDIUMBLOB")
	private byte[] image;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public byte[] getImage() {
		return image;
	}
	public void setImage(byte[] image) {
		this.image = image;
	}
	

}
