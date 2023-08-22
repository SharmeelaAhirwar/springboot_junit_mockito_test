package com.example.testing_Demo_User.service;

import java.util.List;

import com.example.testing_Demo_User.entity.User;

public interface UserService {
	public User createUser(User user);
	public List<User>findAllUser();
	public User updateUser(int id,User user);
	public void deleteUserById(int id);
	public User getUserById(int id);

}
