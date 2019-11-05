package com.flexipgroup.app.user.interfaces;

import com.flexipgroup.app.dto.UserDto;

public interface UserServiceInterface {
	
	UserDto authenticateUser(UserDto user);

	UserDto createUser(UserDto user);
	
}
