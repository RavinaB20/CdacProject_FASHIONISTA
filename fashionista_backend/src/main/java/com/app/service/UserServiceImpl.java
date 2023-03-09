package com.app.service;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.app.dto.ApiResponse;
import com.app.dto.ProductDto;
import com.app.dto.UserDto;
import com.app.dto.UserLoginDto;
import com.app.dto.UserSpecificResponse;
import com.app.exception.ResourceNotFoundException;
import com.app.pojos.User;
import com.app.repository.UserRepository;

@Service
@Transactional
public class UserServiceImpl implements UserService{

	@Autowired
	private UserRepository userRepo;

	@Autowired
	private ModelMapper modelMapper;
	
	@Autowired
	private ShoppingCartService cartService;
	
	@Override
	public List<UserDto> getAllUsersDetails() {
		List<User> users = userRepo.findAll();
		return users.stream().map(UserDto::new).collect(Collectors.toList());
	}

	@Override
	public UserSpecificResponse addNewUser(UserDto user) {
		User newUser = modelMapper.map(user, User.class);
		User cust = userRepo.save(newUser);				
		cartService.createCartForUser(cust);
		return modelMapper.map(cust, UserSpecificResponse.class);	
	}
	
	@Override
	public UserSpecificResponse authenticateUser(UserLoginDto dto) {
		User user = userRepo.findByEmailAndPassword(dto.getEmail(), dto.getPassword()).orElseThrow(()-> new ResourceNotFoundException("Bad Credentials "));
		return modelMapper.map(user, UserSpecificResponse.class);
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
	public UserDto getUserDetails(Long userId) {
		User user = userRepo.findById(userId).orElseThrow(()->new ResourceNotFoundException("Invalid user id... Plz try again"));
		return modelMapper.map(user, UserDto.class);
	}

	@Override
	public UserDto updateUserDetails(Long userId, UserDto userDto) {
		User user = userRepo.findById(userId).orElseThrow(()-> new ResourceNotFoundException("User with user id "+userId+ " not found."));
		if(!(userDto.getDob().equals(user.getDob())))
			user.setDob(userDto.getDob());
		if(!(userDto.getEmail().equals(user.getEmail())))
			user.setEmail(userDto.getEmail());
		if(!(userDto.getFirstName().equals(user.getFirstName())))
			user.setFirstName(userDto.getFirstName());
		if(!(userDto.getLastName().equals(user.getLastName())))
			user.setLastName(userDto.getLastName());
		if(!(userDto.getMobileNo()!=user.getMobileNo()))
			user.setMobileNo(userDto.getMobileNo());
		if(!(userDto.getPassword().equals(user.getPassword())))
			user.setPassword(userDto.getPassword());
		
		return modelMapper.map(user, UserDto.class);
	}

	
	
}
