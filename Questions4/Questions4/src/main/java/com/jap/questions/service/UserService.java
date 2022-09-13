package com.jap.questions.service;

import java.util.List;

import com.jap.questions.entity.User;

public interface UserService {
	
	User createUser(User user) throws Exception;
	User login(User user) throws Exception;
	String mfaConfirmation(int mfapin);
	String deleteUser(String emailId);
	String UpdateUser(User user);
	List<User> getAllUsers();	//import it from util package not from collections
	String forgotPassword(String emailId);
	User getUser(Long id);
	String resetPassword(String token,String password);
	User blockUser(String emailId) throws Exception;
	User activateUser(String emailId) throws Exception;	

}
