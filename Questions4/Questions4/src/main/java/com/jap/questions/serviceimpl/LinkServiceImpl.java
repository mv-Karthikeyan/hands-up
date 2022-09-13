package com.jap.questions.serviceimpl;

import java.util.Calendar;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jap.questions.entity.Link;
import com.jap.questions.repository.LinkRepository;
import com.jap.questions.service.EmailSenderService;
import com.jap.questions.service.LinkService;


@Service
public class LinkServiceImpl implements LinkService{
	
	@Autowired
	private LinkRepository linkRepository;
	
	
	@Autowired
	private EmailSenderService emailSenderService;


	@Override
	public String sendLinkToUser(String emailId, String formLink, String subject, String body) {
		this.emailSenderService.sendSimpleEmail(emailId,body+"\n"+"\n"+"\t"+formLink,subject);
		Link link=new Link();
		link.setEmailId(emailId);
		link.setFormLink(formLink);
		link.setBody(body);
		link.setSubject(subject);
		link.setSentTime(sentTimeMethod());
		this.linkRepository.save(link);
		return null;
	}
	
	private java.util.Date sentTimeMethod() {
		Calendar calendar =Calendar.getInstance();
		calendar.setTimeInMillis(new Date().getTime());
		return new Date(calendar.getTime().getTime());
		
	}


}
