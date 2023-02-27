package com.app.service;

import java.util.List;

import com.app.pojos.User;

public interface UserService {

	List<User> getAllUsersDetails();
	
	User addNewUser(User user);
	
	String deleteUser(Long userId);
	
	User getUserDetails(Long userId);
	
	User updateUserDetails(User user);
	
}
