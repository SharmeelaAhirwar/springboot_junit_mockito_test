package com.example.testing_Demo_User.repositery;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.testing_Demo_User.entity.User;

public interface UserRepo extends JpaRepository<User,Integer> {

}
