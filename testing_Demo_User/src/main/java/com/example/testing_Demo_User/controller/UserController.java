package com.example.testing_Demo_User.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.testing_Demo_User.entity.User;
import com.example.testing_Demo_User.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {
	
	
	@Autowired
	private UserService userService;
	
	
	@PostMapping("/create")
	public ResponseEntity<User>createUser(@RequestBody User user){
		 User createdUser=userService.createUser(user);
		 return new ResponseEntity<User>(user,HttpStatus.OK);
	}
	
	@PutMapping("/update/{id}")
	public ResponseEntity<User>createUser(@RequestBody User user,@PathVariable int id){
		 User updatedUser=userService.updateUser(id, user);
		 return new ResponseEntity<User>(updatedUser,HttpStatus.ACCEPTED);
		 
	}
	
	@GetMapping("/allUser")
	public ResponseEntity<List<User>>findAllUser(){
		List<User>allUser=userService.findAllUser();
		return new ResponseEntity<List<User>>(allUser,HttpStatus.OK);
	}
	
	@DeleteMapping("/deleteById/{id}")
	public ResponseEntity<?>deleteUser(@PathVariable int id){
		userService.deleteUserById(id);
		return new  ResponseEntity(HttpStatus.OK);
	}
	
	
	
	

}
