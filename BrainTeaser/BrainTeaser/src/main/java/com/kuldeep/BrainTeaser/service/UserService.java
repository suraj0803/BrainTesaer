package com.kuldeep.BrainTeaser.service;

import java.util.List;

import org.springframework.http.ResponseEntity;
import com.kuldeep.BrainTeaser.entity.User;
import com.kuldeep.BrainTeaser.payloads.ApiResponse;

public interface UserService {

	public ResponseEntity<ApiResponse> registerUser(User newuser);

	public ResponseEntity<ApiResponse> loginUser(User user);

	public ResponseEntity<ApiResponse> logoutUser(User user);

	public ResponseEntity<ApiResponse> deleteUsers();

	public List<User> getAllUser();

}
