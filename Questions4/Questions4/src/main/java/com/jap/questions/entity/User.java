package com.jap.questions.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;


@Entity
@Table(name="users")
@NoArgsConstructor
@AllArgsConstructor
public class User {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@Column(unique = true)
	@NotEmpty(message="EmailId cannot be Empty")
	@Email(message=" Email Address is not valid!!")
	private String emailId;
	
	
//	@Size(min=4,message="Password must be minimum of 4 characters !!")
//	@Pattern(regexp="^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=\\S+$).*[A-Za-z0-9].{4,}$",message="Passwod Should contain at least 3 characters and at most 20 characters."
//            		+ "It Should contain at least one digit,one upper case alphabet, one lower case alphabet,one special character which includes !@#$%&*()-+=^ and doesn’t contain any white space")
	private String password;
	
	
	
	private int mfapin;
	
	
	private String token;
	
	@NotEmpty(message="Role cannot be Empty")
//	@Pattern(regexp = "Admin|User",message="Roles must be 1)Admin 2)User")
	private String role;
	
	private Date createdDate;
	private Date lastLoginDate;

	
	
	
	
	
	
	
	private boolean isUserBlocked=false;
	public boolean isUserBlocked() {
		return isUserBlocked;
	}

	public void setUserBlocked(boolean isUserBlocked) {
		this.isUserBlocked = isUserBlocked;
	}

	
	
	
	


	
	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getMfapin() {
		return mfapin;
	}

	public void setMfapin(int mfapin) {
		this.mfapin = mfapin;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public Date getLastLoginDate() {
		return lastLoginDate;
	}

	public void setLastLoginDate(Date lastLoginDate) {
		this.lastLoginDate = lastLoginDate;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

}
