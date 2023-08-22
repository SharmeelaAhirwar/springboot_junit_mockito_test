package com.example.testing_Demo_User;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.testing_Demo_User.entity.User;
import com.example.testing_Demo_User.repositery.UserRepo;
import com.example.testing_Demo_User.service.UserService;
import com.example.testing_Demo_User.service.impl.UserServiceImpl;

@SpringBootTest(classes = ServiceMackitoTest.class)
public class ServiceMackitoTest {
	
	@Mock
	UserRepo userRepo;
	
	@InjectMocks
	UserServiceImpl userServiceImpl;
	
	 public List<User>users;
	 
	 @Test
	 public void test_findAllUser() {
		 users=new ArrayList<User>();
		 users.add(new User(1,"sharmi","sharmi@gmail.com"));
		 users.add(new User(2,"s","s@gmail.com"));
		 when(userRepo.findAll()).thenReturn(users);
		 
		  List<User>foundUsers=userServiceImpl.findAllUser();
		 assertEquals(2,foundUsers.size());
		 User foundUser1 = foundUsers.get(0);
	        assertEquals("sharmi", foundUser1.getName());
	        assertEquals("sharmi@gmail.com", foundUser1.getEmail());

	       
	        
		 
		 
	 }
	 
	 @Test
	 public void test_getUserById() {
		 int userId=1;
		 User user=new User();
		 user.setId(userId);
		 user.setEmail("s@gmail.com");
		 user.setName("s");
		 
		 when(userRepo.findById(userId)).thenReturn(Optional.of(user));
		 User foundUser=userServiceImpl.getUserById(userId);
		 assertEquals("s", foundUser.getName());
		 assertEquals("s@gmail.com", foundUser.getEmail());
		 
		 
	 }
	 
	 @Test
	 public void test_updateUser() {
		 
		 int userId=1;
		 User user=new User();
		 user.setEmail("olduser@gmail.com");
		 user.setName("olduser");
		 User updatedUser=new User();
		 updatedUser.setEmail("newuser@gmail.com");
		 updatedUser.setName("new user");
		 
		 when(userRepo.findById(userId)).thenReturn(Optional.of(user));
		 when(userRepo.save(any(User.class))).thenReturn(updatedUser);
		 User foundUser=userServiceImpl.updateUser(userId, updatedUser);
		 assertEquals("new user", foundUser.getName());
	        assertEquals("newuser@gmail.com", foundUser.getEmail());
		 
	 }
	 @Test
	    public void test_DeleteUser() {
	        int userId = 1;
	        userServiceImpl.deleteUserById(userId);

	        Mockito.verify(userRepo, times(1)).deleteById(userId);
	    }
	 @Test
	    public void test_CreateUser() {
	        User newUser = new User();
	        newUser.setName("newuser");
	        newUser.setEmail("newuser@example.com");

	        Mockito.when(userRepo.save(Mockito.any(User.class))).thenReturn(newUser);

	        User createdUser = userServiceImpl.createUser(newUser);

	        assertEquals("newuser", createdUser.getName());
	        assertEquals("newuser@example.com", createdUser.getEmail());
	    }

}
