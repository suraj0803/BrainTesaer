package com.kuldeep.BrainTeaser.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.kuldeep.BrainTeaser.entity.User;
import com.kuldeep.BrainTeaser.payloads.ApiResponse;
import com.kuldeep.BrainTeaser.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService{
	
	@Autowired
	private UserRepository userRepository;
	
	@Override
	public ResponseEntity<ApiResponse> registerUser(User newuser) {
		List<User> users = userRepository.findAll();
		for(User user : users) {
			if(user.equals(newuser)) {
				return new ResponseEntity<ApiResponse>(new ApiResponse("User already Exist !!",true),HttpStatus.OK);
			}
		}
		userRepository.save(newuser);
		return new ResponseEntity<ApiResponse>(new ApiResponse("Successful Registration!!",true),HttpStatus.CREATED);
	}

	@Override
	public ResponseEntity<ApiResponse> loginUser(User user) {
		List<User> users = userRepository.findAll();
		for(User other : users) {
			if(other.getEmail().equals(user.getEmail())	){
				user.setLoggedIn(true);
				userRepository.save(user);
				return new ResponseEntity<ApiResponse>(new ApiResponse("Successfullhy loggedIn !!",true),HttpStatus.OK);
			}
		}
		return new ResponseEntity<ApiResponse>(new ApiResponse("Unsuccessful Login!!",true),HttpStatus.NO_CONTENT);
	}

	@Override
	public ResponseEntity<ApiResponse> logoutUser(User user) {
		List<User> users = userRepository.findAll();
		for(User others : users) {
			if(others.getEmail().equals(user.getEmail())) {
				user.setLoggedIn(false);
				userRepository.save(user);
				return new ResponseEntity<ApiResponse>(new ApiResponse("User LoggedOut Successfully!!",true),HttpStatus.OK);
			}
		}
		return new ResponseEntity<ApiResponse>(new ApiResponse("Unsuccessful logout!!",false),HttpStatus.BAD_REQUEST);
	}

	@Override
	public ResponseEntity<ApiResponse> deleteUsers() {
		userRepository.deleteAll();
		return new ResponseEntity<ApiResponse>(new ApiResponse("Data has been deleted successfully",true),HttpStatus.OK);
	}

	@Override
	public List<User> getAllUser() {
		List<User> users = userRepository.findAll();
		return users;
	}

}
