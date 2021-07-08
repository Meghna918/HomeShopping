package com.meghna.homeshopping.service;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.meghna.homeshopping.entity.ProductEntity;
import com.meghna.homeshopping.entity.ProductImageEntity;
import com.meghna.homeshopping.shared.dto.ProductDto;

public interface ProductService {
	 void addProduct(MultipartFile image,String title,String description,double price,String productGroup);
	 List<ProductEntity> getAllproducts();
	 ProductImageEntity GetImageString(long id);
}
