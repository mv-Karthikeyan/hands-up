package com.jap.questions.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.jap.questions.service.EmailSenderService;

@Service
public class EmailSenderServiceImpl implements EmailSenderService{
	
	@Autowired
	private JavaMailSender mailSender;
	

	@Override
	public void sendSimpleEmail(String toEmail, String body, String subject) {
		SimpleMailMessage message =new SimpleMailMessage();
		message.setFrom("gkishorekumar961@gmail.com");
		message.setTo(toEmail);
		message.setText(body);
		message.setSubject(subject);
		
		
		mailSender.send(message);
		System.out.println("Message Sent.....");
		
		
	}
		
}
