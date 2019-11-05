package com.flexipgroup.authbroker.controllers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.flexipgroup.app.common.Utils;
import com.flexipgroup.app.dto.UserDto;
import com.flexipgroup.app.entity.ServiceEntity;
import com.flexipgroup.app.entity.TokenEntity;
import com.flexipgroup.app.exceptions.UserServiceException;
import com.flexipgroup.app.request.LoginRequest;
import com.flexipgroup.app.response.ServicesResponse;
import com.flexipgroup.app.response.UserResponse;
import com.flexipgroup.app.user.interfaces.UserServiceInterface;
import com.flexipgroup.app.user.repositories.ServiceRepository;
import com.flexipgroup.app.user.repositories.TokenRepository;

import io.jsonwebtoken.Claims;

@RestController
@RequestMapping("authenticate")
public class AuthController {
	
	@Autowired
	UserServiceInterface userService;
	
	@Autowired
	TokenRepository tokenRepository;
	
	@Autowired
	ServiceRepository serviceRepository;
	
	@GetMapping
	public String getAuthentication() {
		return "get Authentication";
	}
	
	@PostMapping("/new")
	public UserResponse createUser (@RequestBody LoginRequest registerRequest) {
		UserResponse returnValue = new UserResponse();

		// UserDto userDto = new UserDto();
		// BeanUtils.copyProperties(userDetails, userDto);
		ModelMapper modelMapper = new ModelMapper();
		UserDto userDto = modelMapper.map(registerRequest, UserDto.class);

		UserDto createdUser;
		try {
			createdUser = userService.createUser(userDto);
			returnValue = modelMapper.map(createdUser, UserResponse.class);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new UserServiceException("Record already exists");
		}
		

		return returnValue;
	}
	
	@PostMapping
	public UserResponse loginUser (@RequestBody LoginRequest loginRequest)
	{
		UserResponse userResponse = new UserResponse();
		
		ModelMapper modelMapper = new ModelMapper();
		UserDto loginData = modelMapper.map(loginRequest, UserDto.class);
		
		try {
			UserDto userDto = userService.authenticateUser(loginData);
			
			if(userDto == null) {
				throw new UserServiceException("User not found");
			}
			
			
			String jwt = Utils.createJWT(
	                userDto.getUserId(),
	                "iss",
	                userDto.getEmail(), // claim = sub
	                800000 // used to calculate expiration (claim = exp)
	        );
			
			TokenEntity token = new TokenEntity();
			token.setToken(jwt);
			token.setUserId(userDto.getUserId());
			System.out.println(token);
			tokenRepository.save(token);
			
			userDto.setToken(jwt);
			
			userResponse = modelMapper.map(userDto, UserResponse.class);
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new UserServiceException("User not found");
		}
		
		return userResponse;
	}
	
	@PostMapping("/get-services")
	public String getServices(@RequestParam(value="token") String token) {
		Iterable<ServiceEntity> services;
		List<String> list = new ArrayList<String>();
		
		// List<ServicesResponse>
		try {
			Claims claim = Utils.decodeJWT(token);
			System.out.println(claim.toString());
			
			services = serviceRepository.findAll();
			for(ServiceEntity service: services) {
				//Map m = new HashMap();
				//m.put("name", service.getName());
				//m.put("description", service.getDescription());
				list.add("Name: " + service.getName() + " Description: " + service.getDescription());
			}
			
		} catch(Exception e) {
			throw new UserServiceException("Invalid token");
		}
		
		return list.toString();
		
	}
	
	
	@PutMapping
	public String updateAuthentication () 
	{
		return "request Authentication";
	}
	
	
	@DeleteMapping
	public String deleteAuthentication ()
	{
		return "delete Authentication";
	}

}
