package com.kuldeep.BrainTeaser.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.kuldeep.BrainTeaser.entity.User;
import com.kuldeep.BrainTeaser.payloads.ApiResponse;
import com.kuldeep.BrainTeaser.service.UserService;

@RestController
public class LoginController {
	
	@Autowired
	private UserService userService;
	
	@PostMapping("/users/register")
	public ResponseEntity<ApiResponse> registerUser(@RequestBody User newuser){
		return this.userService.registerUser(newuser);
	}
	
	@GetMapping("/users/getAllUsers")
	public List<User> getAllUser() {
		return this.userService.getAllUser();
	}
	@PostMapping("/users/login")
	public ResponseEntity<ApiResponse> loginUser(@RequestBody User user){
		return this.userService.loginUser(user);
	}
	
	@PostMapping("/user/logout")
	public ResponseEntity<ApiResponse> logoutUser(@RequestBody User user){
		return this.userService.logoutUser(user);
	}
	
	@DeleteMapping("/users/all")
	public ResponseEntity<ApiResponse> deleteUsers(){
		return this.userService.deleteUsers();
	}
}
