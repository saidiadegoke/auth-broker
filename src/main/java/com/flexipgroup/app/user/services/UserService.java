package com.flexipgroup.app.user.services;

import org.modelmapper.ModelMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.flexipgroup.app.common.Utils;
import com.flexipgroup.app.dto.UserDto;
import com.flexipgroup.app.entity.UserEntity;
import com.flexipgroup.app.exceptions.UserServiceException;
import com.flexipgroup.app.user.interfaces.UserServiceInterface;
import com.flexipgroup.app.user.repositories.UserRepository;

import at.favre.lib.crypto.bcrypt.BCrypt;

@Service
public class UserService implements UserServiceInterface {
	
	@Autowired
	UserRepository userRepository;
	
	@Autowired
	Utils utils;
	
	@Autowired
	//BCrypt bCryptPasswordEncoder;

	@Override
	public UserDto authenticateUser(UserDto user) {

		//UserEntity userEntity = userRepository.findByUserId(user.getUserId());
		UserEntity userEntity = userRepository.findByEmail(user.getEmail());
		UserDto userDto = new UserDto();
		
		if(userEntity == null) {
			//throw new UserServiceException("User not found");
			return null;
		}
		
		BeanUtils.copyProperties(userEntity, userDto);
		
		return userDto;
	}
	
	@Override
	public UserDto createUser(UserDto user) {

		if (userRepository.findByEmail(user.getEmail()) != null) {
			//throw new UserServiceException("Record already exists");
			return null;
		}
		  
		//BeanUtils.copyProperties(user, userEntity);
		ModelMapper modelMapper = new ModelMapper();
		UserEntity userEntity = modelMapper.map(user, UserEntity.class);

		String publicUserId = utils.generateUserId(30);
		userEntity.setUserId(publicUserId);
		userEntity.setEncryptedPassword(BCrypt.withDefaults().hashToString(12, user.getPassword().toCharArray()));
		//userEntity.setEmailVerificationToken(utils.generateEmailVerificationToken(publicUserId));

		UserEntity storedUserDetails = userRepository.save(userEntity);
 
		//BeanUtils.copyProperties(storedUserDetails, returnValue);
		UserDto returnValue  = modelMapper.map(storedUserDetails, UserDto.class);
		
        // Send an email message to user to verify their email address
		//amazonSES.verifyEmail(returnValue);

		return returnValue;
	}

}
