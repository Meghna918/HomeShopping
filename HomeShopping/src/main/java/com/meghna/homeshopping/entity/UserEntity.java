package com.meghna.homeshopping.entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;



@Entity(name="userdetails")
public class UserEntity implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8962007484774477733L;
	
	@Id
	@GeneratedValue
	private long id;
	
	@Column(nullable=false)
	private String userId;
	
	@Column(nullable=false)
	private String name;
	
	@Column(nullable=false,length=50)
	private String phoneNumber;
	
	@Column(nullable=false,length=100)
	private String email;

	@Column(nullable=false)
	private String encryptedPassword;
	
	private String phoneNumberVerificationToken;
	
	@Column(nullable=false)
	private Boolean phoneNumberVerificationStatus=false;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getEncryptedPassword() {
		return encryptedPassword;
	}

	public void setEncryptedPassword(String encryptedPassword) {
		this.encryptedPassword = encryptedPassword;
	}

	public String getPhoneNumberVerificationToken() {
		return phoneNumberVerificationToken;
	}

	public void setPhoneNumberVerificationToken(String phoneNumberVerificationToken) {
		this.phoneNumberVerificationToken = phoneNumberVerificationToken;
	}

	public Boolean getPhoneNumberVerificationStatus() {
		return phoneNumberVerificationStatus;
	}

	public void setPhoneNumberVerificationStatus(Boolean phoneNumberVerificationStatus) {
		this.phoneNumberVerificationStatus = phoneNumberVerificationStatus;
	}
	
	

}
