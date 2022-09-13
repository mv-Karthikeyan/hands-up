package com.jap.questions.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.jap.questions.service.LinkService;

@RestController
@RequestMapping("/iRecruit")
@CrossOrigin
public class LinkController {
	
	@Autowired
	private LinkService linkService;
	
	@GetMapping("/hello")
	public String helloworld()
	{
		return "Hello User";
	}
	
	
	@GetMapping("/sendlink")
	public String sendLink(@RequestParam String emailId,@RequestParam String formLink,@RequestParam String subject,@RequestParam String body)
	{
		this.linkService.sendLinkToUser(emailId, formLink, subject, body);
		return "Link Sent Successfully";
	}
	
	
	
	
	
}