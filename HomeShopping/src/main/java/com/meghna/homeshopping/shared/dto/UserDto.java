package com.meghna.homeshopping.shared.dto;

import java.io.Serializable;

public class UserDto implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -7921732540573103332L;
	
	private long id;
	private String userId;
	private String name;
	private String phoneNumber;
	private String email;
	private String password;
	private String encryptedPssword;
	private String phoneNumberVerificationToken;
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
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEncryptedPssword() {
		return encryptedPssword;
	}
	public void setEncryptedPssword(String encryptedPssword) {
		this.encryptedPssword = encryptedPssword;
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
