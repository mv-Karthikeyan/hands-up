package com.jap.questions.service;

public interface EmailSenderService {
	
	void sendSimpleEmail(String toEmail,String body,String subject);

}
