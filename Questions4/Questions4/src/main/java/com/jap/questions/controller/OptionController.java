package com.jap.questions.controller;

import java.util.ArrayList;
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

import com.jap.questions.entity.MultipleOptions;
import com.jap.questions.entity.Options;
import com.jap.questions.entity.Questions;
import com.jap.questions.repository.OptionsRepository;
import com.jap.questions.repository.QuestionRepository;
import com.jap.questions.service.OptionsService;



@RestController
@RequestMapping("/iRecruit")
@CrossOrigin
public class OptionController {
	
	@Autowired
	private QuestionRepository questionRepository;
	
	@Autowired
	private OptionsRepository optionRepository;
	
	@Autowired
	private OptionsService optionService;
	
	
	@PostMapping("/addmultipleoptions/{questionId}")
	public String createMultipleOptions(@RequestBody MultipleOptions multipleOptions, @PathVariable Long questionId)
	{
		Questions question=this.questionRepository.findById(questionId).orElseThrow();
		List<Options> optionsEntity = new ArrayList<>();
		multipleOptions.getOptions().forEach(each ->{
			Options option=new Options();
			option.setOptionName(each.getOptionName());
			option.setQuestionName(question);
			optionsEntity.add(option);
		});
		this.optionRepository.saveAll(optionsEntity);
		return "Options added to the question ;"+question.getQuestion()+" Successfully";
		
	}
	
	@PostMapping("/addoption/{questionId}")
	public String addOption(@RequestBody Options option,@PathVariable Long questionId)
	{
		
		return this.optionService.createOption(option,questionId);
		
	}
	
	@PutMapping("/updateoption/{optionId}")
	public Options updateOption(@RequestBody Options option,@PathVariable Long optionId)
	{
		return this.optionService.updateOption(option, optionId);
		
	}
	
	@DeleteMapping("/deleteoption/{optionId}")
	public String deleteOption(@PathVariable Long optionId)
	{
		return this.optionService.deleteOption(optionId);
	}
	
	@GetMapping("/getalloptions/{questionId}")
	public List<Options> getAllOptionsOfAQuestion(@PathVariable Long questionId)
	{
		return this.optionService.getAllOptionsOfQuestions(questionId);
	}
	
}