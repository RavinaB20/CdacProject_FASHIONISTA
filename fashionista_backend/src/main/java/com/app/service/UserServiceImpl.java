package com.app.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.exception.ResourceNotFoundException;
import com.app.pojos.User;
import com.app.repository.UserRepository;

@Service
@Transactional
public class UserServiceImpl implements UserService{

	@Autowired
	private UserRepository userRepo;

	@Override
	public List<User> getAllUsersDetails() {
		return userRepo.findAll();
	}

	@Override
	public User addNewUser(User user) {
		return userRepo.save(user);
	}

	@Override
	public String deleteUser(Long userId) {
		String mesg = "delete user failed...";
		if(userRepo.existsById(userId))
		{
			userRepo.deleteById(userId);
			mesg = "User deleted successfully...";
		}
		return mesg;
	}

	@Override
	public User getUserDetails(Long userId) {
		return userRepo.findById(userId).orElseThrow(()->new ResourceNotFoundException("Invalid user id... Plz try again"));
	}

	@Override
	public User updateUserDetails(User user) {
		if(userRepo.existsById(user.getId())) {
			System.out.println("In service update user");
			return userRepo.save(user);
		}
		throw new ResourceNotFoundException("User record not exists...");
	}
	
	
}
