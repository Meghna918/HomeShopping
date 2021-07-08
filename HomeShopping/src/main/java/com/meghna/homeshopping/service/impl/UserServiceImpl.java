package com.meghna.homeshopping.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.meghna.homeshopping.entity.UserEntity;
import com.meghna.homeshopping.repositories.UserRepository;
import com.meghna.homeshopping.service.UserService;
import com.meghna.homeshopping.shared.Utils;
import com.meghna.homeshopping.shared.dto.UserDto;

@Service
public class UserServiceImpl implements UserService {
    
	@Autowired
	UserRepository userRepository;
	
	@Autowired 
	Utils utils;
	
	@Autowired
	BCryptPasswordEncoder bCryptPasswordEncoder;
	
	@Override
	public UserDto createUser(UserDto user) {
		
		
		if(userRepository.findByPhoneNumber(user.getPhoneNumber())!=null) throw new RuntimeException("Record already exist");
		UserEntity userEntity=new UserEntity();
		BeanUtils.copyProperties(user, userEntity);
		
		String publicUserId=utils.generateUserId(30);
		userEntity.setUserId(publicUserId);
		userEntity.setEncryptedPassword(bCryptPasswordEncoder.encode(user.getPassword()));
		UserEntity storedUserDetails=userRepository.save(userEntity);
		
		
		UserDto returnValue=new UserDto();
		BeanUtils.copyProperties(storedUserDetails, returnValue);
		
		return returnValue;
	}
	@Override
	public UserDto getUser(String phoneNumber) {
		UserEntity userEntity=userRepository.findByPhoneNumber(phoneNumber);
		if(userEntity==null) throw new UsernameNotFoundException(phoneNumber);
		UserDto returnValue=new UserDto();
		BeanUtils.copyProperties(userEntity, returnValue);
		return returnValue;
		
	}

	@Override
	public UserDetails loadUserByUsername(String phoneNumber) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		UserEntity userEntity=userRepository.findByPhoneNumber(phoneNumber);
		if(userEntity==null) throw new UsernameNotFoundException(phoneNumber);
		
		return new User(userEntity.getPhoneNumber(),userEntity.getEncryptedPassword(),new ArrayList<>());
	}
	@Override
	public UserDto getUserByUserId(String userId) {
		// TODO Auto-generated method stub
		UserDto returnValue=new UserDto();
		UserEntity userEntity=userRepository.findByUserId(userId);
		if(userEntity==null) throw new UsernameNotFoundException("userid not found");
		BeanUtils.copyProperties(userEntity, returnValue);
		return returnValue;
	}
	@Override
	public UserDto updateUser(String userId, UserDto user) {
		// TODO Auto-generated method stub
		UserDto returnValue=new UserDto();
		UserEntity userEntity=userRepository.findByUserId(userId);
		if(userEntity==null) throw new UsernameNotFoundException(userId);
		userEntity.setName(user.getName());
		userEntity.setEmail(user.getEmail());
		UserEntity updatedUserDetails=userRepository.save(userEntity);
		BeanUtils.copyProperties(updatedUserDetails, returnValue);
		return returnValue;
	}
	@Override
	public void deleteUser(String userId) {
		// TODO Auto-generated method stub
		UserEntity userEntity=userRepository.findByUserId(userId);
		if(userEntity==null) throw new UsernameNotFoundException(userId);
		userRepository.delete(userEntity);
	}
	@Override
	public List<UserDto> getUsers(int page,int limit) {
		// TODO Auto-generated method stub
		List<UserDto> returnValue=new ArrayList<>();
		if (page>0) page=page-1;
		Pageable pageableRequest=PageRequest.of(page, limit);
	    Page<UserEntity> usersPage=userRepository.findAll(pageableRequest);
	    List <UserEntity> users=usersPage.getContent();
	    for (UserEntity userEntity:users) {
	    	UserDto userDto=new UserDto();
	    	BeanUtils.copyProperties(userEntity, userDto);
	    	returnValue.add(userDto);
	    }
		
		
		return returnValue;
	}

}
