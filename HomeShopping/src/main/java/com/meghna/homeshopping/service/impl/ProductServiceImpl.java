package com.meghna.homeshopping.service.impl;
import org.springframework.util.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import java.util.List;
import java.util.Optional;

import javax.imageio.ImageIO;

import com.meghna.homeshopping.service.ProductService;
import com.meghna.homeshopping.shared.Utils;
import com.meghna.homeshopping.shared.dto.ProductDto;
import com.meghna.homeshopping.shared.dto.UserDto;
import com.meghna.homeshopping.entity.ProductEntity;
import com.meghna.homeshopping.entity.ProductImageEntity;
import com.meghna.homeshopping.entity.UserEntity;
import com.meghna.homeshopping.repositories.ProductRepository;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.sql.Blob;
import java.util.ArrayList;
import java.util.Base64;
@Service
public class ProductServiceImpl implements ProductService {
	
	@Autowired
	ProductRepository productRepository;
	

	
	
	@Override
	public void addProduct(MultipartFile image,String title,String description,double price,String productGroup) {
		ProductEntity productEntity=new ProductEntity();
		ProductImageEntity productImageEntity=new ProductImageEntity(); 
		String fileName = StringUtils.cleanPath(image.getOriginalFilename());
		if(fileName.contains(".."))
		{
			System.out.println("not a a valid file");
		}
		try {
			productImageEntity.setImage(image.getBytes());
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		productEntity.setProductImageEntity(productImageEntity);
		productEntity.setTitle(title);
		productEntity.setPrice(price);
		productEntity.setDescription(description);
		productEntity.setProductGroup(productGroup);
		
		productRepository.save(productEntity);
		
		}

	@Override
	public List<ProductEntity> getAllproducts(){
	return productRepository.findAll();
		
		}
	
	@Override 
	public ProductImageEntity GetImageString(long id) {
		return productRepository.findById(id).get().getProductImageEntity();
			
}
}
    

		
	

