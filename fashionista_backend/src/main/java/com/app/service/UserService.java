package com.app.service;

import java.io.IOException;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.app.dto.ApiResponse;
import com.app.dto.UserDto;
import com.app.dto.UserLoginDto;
import com.app.dto.UserSpecificResponse;
import com.app.pojos.User;

public interface UserService {

	List<UserDto> getAllUsersDetails();
	
	UserSpecificResponse addNewUser(UserDto user);
	
	String deleteUser(Long userId);
	
	UserDto getUserDetails(Long userId);
	
	UserDto updateUserDetails(Long userId, UserDto userDto);
	
	UserSpecificResponse authenticateUser(UserLoginDto dto);
}
