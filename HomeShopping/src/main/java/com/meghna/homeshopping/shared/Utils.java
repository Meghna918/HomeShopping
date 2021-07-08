package com.meghna.homeshopping.shared;

import java.security.SecureRandom;
import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;

import org.springframework.stereotype.Service;


@Service
public class Utils {
	private final Random RANDOM=new SecureRandom();
	private final String ALPHABET="0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
	private static final AtomicInteger count = new AtomicInteger(0); 
	private String productId;
	public String generateUserId(int length) {
		return generateRandomString(length);
	}
	private String generateRandomString(int length) {
		StringBuilder returnValue=new StringBuilder(length);
		for(int i=0;i<length;i++) {
			returnValue.append(ALPHABET.charAt(RANDOM.nextInt(ALPHABET.length())));
		}
		return new String(returnValue);
	}
	public String generateProductId() {
		productId="P"+count.incrementAndGet();
		return productId;
	}
	

}
