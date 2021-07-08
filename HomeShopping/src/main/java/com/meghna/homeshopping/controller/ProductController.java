package com.meghna.homeshopping.controller;


import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.meghna.homeshopping.entity.ProductEntity;
import com.meghna.homeshopping.entity.ProductImageEntity;
import com.meghna.homeshopping.exceptions.UserServiceExceptions;
import com.meghna.homeshopping.model.request.ProductRequestModel;
import com.meghna.homeshopping.model.request.UserDetailsRequestModel;
import com.meghna.homeshopping.model.response.ErrorMessages;
import com.meghna.homeshopping.model.response.ProductResponse;
import com.meghna.homeshopping.model.response.ProductResponseModel;
import com.meghna.homeshopping.model.response.UserRest;
import com.meghna.homeshopping.service.ProductService;
import com.meghna.homeshopping.shared.dto.ProductDto;
import com.meghna.homeshopping.shared.dto.UserDto;

@RestController
@RequestMapping("products")
@CrossOrigin
public class ProductController {
	@Autowired
	ProductService productService;
	@PostMapping
	public String addProduct(@RequestParam("image") MultipartFile image,
			@RequestParam("title") String title,
			@RequestParam("description") String description,
			@RequestParam("price") Double price,
			@RequestParam("productGroup") String ProductGroup) throws Exception
	{
		
		
		productService.addProduct(image,title,description,price,ProductGroup);
		
		
		return "product record added successfully";
		
	}
	@GetMapping
	public List<ProductEntity> getAllproducts(){
		
		List<ProductEntity> products=productService.getAllproducts();
		
		return products;
		
	}
	
     @RequestMapping(value = "{productId}", method = RequestMethod.GET)
	    public ResponseEntity getImage(@PathVariable("productId") Long imageId) {
	        ProductImageEntity image = productService.GetImageString(imageId);
	        if (image == null) {
	            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	        }
	        return ResponseEntity.ok().header(HttpHeaders.CONTENT_TYPE, "image/*").body(image.getImage());
	    }
	}

