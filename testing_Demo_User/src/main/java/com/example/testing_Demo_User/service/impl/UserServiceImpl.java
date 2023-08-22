package com.example.testing_Demo_User.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.testing_Demo_User.entity.User;
import com.example.testing_Demo_User.repositery.UserRepo;
import com.example.testing_Demo_User.service.UserService;

@Service
public class UserServiceImpl implements UserService {
	
	
	@Autowired
	private UserRepo userRepo;
	

	@Override
	public User createUser(User user) {
		
		User addedUser=userRepo.save(user);
		return addedUser;
	}

	@Override
	public List<User> findAllUser() {
		 return userRepo.findAll();
		
		
	}

	@Override
	public User updateUser(int id,User user) {
		User savedUser=this.userRepo.findById(id).get();
		savedUser.setEmail(user.getEmail());
		savedUser.setName(user.getName());
		
		
		
		return userRepo.save(savedUser);
	}

	@Override
	public void deleteUserById(int id) {
		this.userRepo.deleteById(id);
		
	}

	@Override
	public User getUserById(int id) {
		// TODO Auto-generated method stub
		return userRepo.findById(id).get();
	}

}
