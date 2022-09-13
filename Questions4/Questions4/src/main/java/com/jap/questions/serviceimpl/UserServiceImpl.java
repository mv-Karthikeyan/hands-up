package com.jap.questions.serviceimpl;

import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.jasypt.util.text.AES256TextEncryptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jap.questions.entity.User;
import com.jap.questions.repository.UserRepository;
import com.jap.questions.service.EmailSenderService;
import com.jap.questions.service.UserService;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class UserServiceImpl implements UserService{
	
	@Autowired
	private UserRepository userRepository;

	
	@Autowired
	private EmailSenderService emailSenderService;
	
	
	@Override
	public User createUser(User user) throws Exception {
		AES256TextEncryptor aes=new AES256TextEncryptor();
		String secretKey="AWs$1@2345wa";
		aes.setPassword(secretKey);
		
		if(user.getRole().contentEquals("Admin") | user.getRole().contentEquals("User"))
		{
		
			User userObj=this.userRepository.findByEmailId(user.getEmailId());
			if(userObj==null)
			{
				String encryptedPassword=aes.encrypt(user.getPassword());
				user.setPassword(encryptedPassword);
				user.setCreatedDate(createdTimeMethod());
				this.userRepository.save(user);
				log.info(user.getEmailId()+": Registered Successfully");
				return user;
	
			}
			throw new Exception(user.getEmailId()+": User Exists with this emailId");
		}
		throw new Exception("Roles must be Admin or User");
		
	}
	
	private java.util.Date createdTimeMethod() {
		Calendar calendar =Calendar.getInstance();
		calendar.setTimeInMillis(new Date().getTime());
		return new Date(calendar.getTime().getTime());
		
	}

	@Override
	public User login(User user) throws Exception {
		AES256TextEncryptor aes=new AES256TextEncryptor();
		String secretKey="AWs$1@2345wa";
		aes.setPassword(secretKey);
		
		
		User userObj=this.userRepository.findByEmailId(user.getEmailId());
		if(userObj!=null)
		{	
			if(userObj.isUserBlocked()==false)
			{
				String decryptedPassword=aes.decrypt(userObj.getPassword());
				if(decryptedPassword.contentEquals(user.getPassword()))
				{
						
					userObj.setLastLoginDate(createdTimeMethod());
					this.userRepository.save(userObj);			
					log.info(user.getEmailId()+": User Logged in Successfully!!");
					return userObj;
				
				}
				throw new Exception(user.getEmailId()+": has entered Wrong Password");
				
			}
			
			throw new Exception(user.getEmailId()+": Access Denied.You don't have permissions to Login");
			
		}
		
		throw new Exception(user.getEmailId()+": Bad Credentials");
	}

	@Override
	public String mfaConfirmation(int mfapin) {
		Optional<User> userOptional = Optional
				.ofNullable(userRepository.findByMfapin(mfapin));
		
		
		if (!userOptional.isPresent()) {
			log.info("Entered invalid mfa pin");
			return "Invalid Code";
		}
		User user = userOptional.get();
		user.setMfapin(0);
		user = userRepository.save(user);
		log.info(user.getEmailId()+": logged in successfully!!");
		return "Login Successfull  !!";
	}

	@Override
	public String deleteUser(String emailId) {
		User userObj=this.userRepository.findByEmailId(emailId);
		if(userObj==null)
		{
			return "user not found with this emailid : "+emailId;
		}
		this.userRepository.delete(userObj);
		log.info(emailId+": has been deleted");
		return "user DELETED successfully : "+emailId;
	}

	@Override
	public String UpdateUser(User user) {
		AES256TextEncryptor aes=new AES256TextEncryptor();
		String secretKey="AWs$1@2345wa";
		aes.setPassword(secretKey);
		User UserObj=this.userRepository.findByEmailId(user.getEmailId());
		if(UserObj==null)
		{
			log.info(user.getEmailId()+": user not found with this emailId");
			return "User not found with emailId : "+user.getEmailId();
		}
		String encrypedPassword =aes.encrypt(user.getPassword());
		UserObj.setPassword(encrypedPassword);
		this.userRepository.save(UserObj);
		log.info(user.getEmailId()+":password updated successfully!!");
		return UserObj.getEmailId()+" User password updated Successfully";
	}

	@Override
	public List<User> getAllUsers() {
		log.info("Fetched all the users data");
		List<User> users=this.userRepository.findAll();
		return users;
	}

	@Override
	public String forgotPassword(String emailId) {
		User userObj=this.userRepository.findByEmailId(emailId);
		if(userObj==null)
		{
			log.info(emailId+": user does not exists in the database ,but tried to change the password");
			return "Invalid EmailId";
		}
		String generatedToken=UUID.randomUUID().toString();
		userObj.setToken(generatedToken);
		this.userRepository.save(userObj);
		String response="http://localhost:9090/iRecruit/user/reset-password?token=" +generatedToken;
		this.emailSenderService.sendSimpleEmail(userObj.getEmailId(),"Hey!!"+userObj.getEmailId()+"Click the below link to reset your password\n"+response,"Reset Password Link");
		log.info(emailId+": sent forgot password link to the user");
		return response;
	}

	@Override
	public User getUser(Long id) {
		log.info("Fetched user data");
		return (User) this.userRepository.findById(id).orElse(null);
	}

	@Override
	public String resetPassword(String token, String password) {
		AES256TextEncryptor aes=new AES256TextEncryptor();
		String secretKey="AWs$1@2345wa";
		aes.setPassword(secretKey);
		User userObj=this.userRepository.findByToken(token);
		if(userObj!=null)
		{
			String encryptedPassword=aes.encrypt(password);
			userObj.setPassword(encryptedPassword);
			userObj.setToken(null);
			this.userRepository.save(userObj);
			log.info(userObj.getEmailId()+": Password updated Successfully!!");
			return "Password updated successfully";
		}
		log.info(token +": Invalid Token");
		return "Invalid Token";
	}

	@Override
	public User blockUser(String emailId) throws Exception {
		User userObj=this.userRepository.findByEmailId(emailId);
		if(userObj==null)
		{
			throw new Exception("User not found with EmailId :"+emailId);
		}
		userObj.setUserBlocked(true);
		this.userRepository.save(userObj);
		log.info(emailId+": User Blocked");
		return userObj;
	}

	@Override
	public User activateUser(String emailId) throws Exception {
		User userObj=this.userRepository.findByEmailId(emailId);
		if(userObj==null)
		{
			throw new Exception("User does not exists with EmailId :"+emailId);
		}
		userObj.setUserBlocked(false);
		this.userRepository.save(userObj);
		log.info(emailId+": User activated");
		return userObj;
	}
	
	

}
