package com.app.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.dto.ApiResponse;
import com.app.dto.UserDto;
import com.app.dto.UserLoginDto;
import com.app.dto.UserSpecificResponse;
import com.app.pojos.User;
import com.app.service.UserService;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/users")
public class UserController {

	@Autowired
	private UserService userSer;
	
	public UserController() {
		System.out.println("In def ctor of "+getClass());
	}

	//URL : http://host:post/users method=get
	@GetMapping
	public List<UserDto> getUsers(){
		System.out.println("In user getUsers");
		return  userSer.getAllUsersDetails();
	}
	
	//URL : http://host:post/users method=post
	@PostMapping("/register")
	public UserSpecificResponse addNewUser(@RequestBody UserDto newUser) {
		System.out.println("In add new user");
		return userSer.addNewUser(newUser);
	}
	
	@DeleteMapping("/{userId}")
	public ApiResponse deleteUser(@PathVariable Long userId) {
		System.out.println("In delete user");	
		return new ApiResponse(userSer.deleteUser(userId));
	}
	
	@GetMapping("/{userId}")
	public UserDto getUserDetails(@PathVariable Long userId) {
		return userSer.getUserDetails(userId);
	}
	
	@PutMapping("/{userId}")
	public UserDto updateUserDetails(@PathVariable Long userId, @RequestBody UserDto userDto) {
		System.out.println("In update user");
		//user.setId(user.getId());
		return userSer.updateUserDetails(userId, userDto);
	}
	
	@PostMapping("/login")
	public ResponseEntity<?> validateUser(@RequestBody @Valid UserLoginDto dto){
		return ResponseEntity.ok(userSer.authenticateUser(dto));
	}
			
}
