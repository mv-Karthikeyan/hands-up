package com.jap.questions.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.jap.questions.entity.User;
import com.jap.questions.service.UserService;

@RestController
@RequestMapping("/iRecruit")
@CrossOrigin
public class UserController {

	
	
	@Autowired
	private UserService userService;
	
	
	
	//register user
	
	@PostMapping("/register")
	public User createUser(@Valid @RequestBody User user) throws Exception
	{
		User response=this.userService.createUser(user);
		return response;
		
	}
	
	//login 
	
	@PostMapping("/login")
	public User  login(@RequestBody User user) throws Exception
	{
		User response= this.userService.login(user);
		return response;

		
	}
	
	// mfa 
	
	@GetMapping("/authentication")
	public String userVerification(@RequestBody User user)
	{
		String response=this.userService.mfaConfirmation(user.getMfapin());
		return response;
		
	}
	
	
	//get all users
	
	
	@GetMapping("/users")
	public List<User> getAllUsers()
	{
		List<User> users=this.userService.getAllUsers();
		return users;
	}
	
	//get by id
	
	
		@GetMapping("/user/{id}")
		public User getUser(@PathVariable Long id)
		{
			return this.userService.getUser(id);
		}
	
	
	//delete user 
	
	
	@DeleteMapping("/delete/{emailId}")
	public String deleteUser(@PathVariable String emailId)
	{
		return this.userService.deleteUser(emailId);
		
	}
	
	
	// update user
	
	
	@PutMapping("/update")
	public String updateUser(@RequestBody User user)
	{
		String response=this.userService.UpdateUser(user);
		return response;
		
	}
	
	//forgot password
	
	@PostMapping("/forgot-password")
	public String forgotPassword(@RequestBody User user)
	{
		return this.userService.forgotPassword(user.getEmailId());
	}
	
	@PutMapping("/reset-password")
	public String resetPassword(@RequestParam String token,@RequestParam String password)
	{
		return this.userService.resetPassword(token, password);
		
		
	}
	
	@PutMapping("/user/block/{emailId}")
	public User blockUser(@PathVariable String emailId) throws Exception
	{
		User userObj=this.userService.blockUser(emailId);
		return userObj;
	}
	
	@PutMapping("/user/activate/{emailId}")
	public User activateUser(@PathVariable String emailId) throws Exception
	{
		User userObj=this.userService.activateUser(emailId);
		return userObj;
	}
	
}
