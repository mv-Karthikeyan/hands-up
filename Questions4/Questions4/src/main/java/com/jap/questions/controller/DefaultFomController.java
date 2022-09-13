package com.jap.questions.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jap.questions.entity.DefaultForm;
import com.jap.questions.service.DefaultFormService;



@RestController
@RequestMapping("/iRecruit")
@CrossOrigin
public class DefaultFomController {
	
	@Autowired
	private DefaultFormService defaultFormService;
	
	@PostMapping("/createform/{sectionId}")
	public String createNewForm(@RequestBody DefaultForm defaultForm,@PathVariable Long sectionId) throws Exception
	{
		return this.defaultFormService.createDefaultForm(defaultForm,sectionId);
		
	}
	
	
	@GetMapping("/getallforms")
	public List<DefaultForm> getAllForms()
	{
		return this.defaultFormService.getAllDefaultForms();
	}
	
	
	@DeleteMapping("/deleteform")
	public String deleteForm(@PathVariable String dfId)
	{
		return this.defaultFormService.deleteDefaultForm(dfId);
	} 
	

	@PutMapping("/editform/{dfId}")
	public String editForm(@RequestBody DefaultForm defaultForm,@PathVariable String dfId)
	{
		return this.defaultFormService.editDefaultForm(defaultForm, dfId);
	}
	
	
	@PostMapping("/copy/{dfId}")
	public DefaultForm copyForm(@PathVariable String dfId)
	{
		return this.defaultFormService.copyForm(dfId);
	}
	

}
