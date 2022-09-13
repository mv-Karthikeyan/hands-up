package com.jap.questions.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jap.questions.entity.User;

public interface UserRepository extends JpaRepository<User,Long>{
	
	public User findByEmailId(String emailId);
	public User findByEmailIdAndPassword(String emailId,String password);
	public User findByMfapin(int mfapin);
	public User findByToken(String token);

}
