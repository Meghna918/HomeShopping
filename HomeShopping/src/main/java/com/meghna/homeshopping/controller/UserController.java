package com.meghna.homeshopping.controller;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.meghna.homeshopping.exceptions.UserServiceExceptions;
import com.meghna.homeshopping.model.request.UserDetailsRequestModel;
import com.meghna.homeshopping.model.response.ErrorMessages;
import com.meghna.homeshopping.model.response.OperationStatusModel;
import com.meghna.homeshopping.model.response.RequestOperationName;
import com.meghna.homeshopping.model.response.RequestOperationStatus;
import com.meghna.homeshopping.model.response.UserRest;
import com.meghna.homeshopping.service.UserService;
import com.meghna.homeshopping.shared.dto.UserDto;

import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("users")
@CrossOrigin
public class UserController {
	@Autowired
	UserService userService;
	@GetMapping(path="/{id}",produces= { MediaType.APPLICATION_XML_VALUE,MediaType.APPLICATION_JSON_VALUE})
	public UserRest getUser(@PathVariable String id)
	{
		UserRest returnValue=new UserRest();
		UserDto userDto=userService.getUserByUserId(id);
		BeanUtils.copyProperties(userDto, returnValue);
		return returnValue;
	}
	@PostMapping(consumes= { MediaType.APPLICATION_XML_VALUE,MediaType.APPLICATION_JSON_VALUE},
			produces= { MediaType.APPLICATION_XML_VALUE,MediaType.APPLICATION_JSON_VALUE})
	public UserRest createUser(@RequestBody UserDetailsRequestModel userDetails) throws Exception
	{
		UserRest returnValue=new UserRest();
		
		if(userDetails.getName().isEmpty()) throw new UserServiceExceptions(ErrorMessages.MISSING_REQUIRED_FIELD.getErrorMessage());
		UserDto userDto=new UserDto();
		BeanUtils.copyProperties(userDetails, userDto);
		
		UserDto createdUser=userService.createUser(userDto);
		BeanUtils.copyProperties(createdUser, returnValue);
		return returnValue;
		
	}
	@PutMapping(path="/{id}",consumes= { MediaType.APPLICATION_XML_VALUE,MediaType.APPLICATION_JSON_VALUE},
			produces= { MediaType.APPLICATION_XML_VALUE,MediaType.APPLICATION_JSON_VALUE})
	public UserRest updateUser(@PathVariable String id,@RequestBody UserDetailsRequestModel userDetails)
	{
        UserRest returnValue=new UserRest();
		
		if(userDetails.getName().isEmpty()) throw new UserServiceExceptions(ErrorMessages.MISSING_REQUIRED_FIELD.getErrorMessage());
		UserDto userDto=new UserDto();
		BeanUtils.copyProperties(userDetails, userDto);
		
		UserDto createdUser=userService.updateUser(id,userDto);
		BeanUtils.copyProperties(createdUser, returnValue);
		return returnValue;
	}
	@DeleteMapping(path="/{id}")
	public OperationStatusModel deleteUser(@PathVariable String id)
	{
		OperationStatusModel returnValue=new OperationStatusModel();
		returnValue.setOperationName(RequestOperationName.DELETE.name());
		userService.deleteUser(id);
		returnValue.setOperationResult(RequestOperationStatus.SUCCESS.name());
		return returnValue;
		}
	@GetMapping(produces= { MediaType.APPLICATION_XML_VALUE,MediaType.APPLICATION_JSON_VALUE})
	public List<UserRest> getUsers(@RequestParam(value="page",defaultValue="0")int page,
			@RequestParam(value="limit",defaultValue="25")int limit)
	{
		List<UserRest> returnValue=new ArrayList<>();
		List<UserDto> users=userService.getUsers(page,limit);
		for (UserDto userDto:users) {
			UserRest userModel=new UserRest();
			BeanUtils.copyProperties(userDto, userModel);
			returnValue.add(userModel);
		}
		return returnValue;
		
	}
}