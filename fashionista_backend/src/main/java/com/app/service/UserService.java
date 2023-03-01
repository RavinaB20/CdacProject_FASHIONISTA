package com.app.service;

import java.io.IOException;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.app.dto.ApiResponse;
import com.app.pojos.User;

public interface UserService {

	List<User> getAllUsersDetails();
	
	User addNewUser(User user);
	
	String deleteUser(Long userId);
	
	User getUserDetails(Long userId);
	
	User updateUserDetails(User user);
	
}
