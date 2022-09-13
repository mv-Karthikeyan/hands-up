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

import com.jap.questions.entity.Category;
import com.jap.questions.entity.DefaultForm;
import com.jap.questions.entity.MulltipleQuestions;
import com.jap.questions.entity.MultipleOptions;
import com.jap.questions.entity.Options;
import com.jap.questions.entity.Questions;
import com.jap.questions.repository.CategoryRepository;
import com.jap.questions.repository.OptionsRepository;
import com.jap.questions.repository.QuestionRepository;
import com.jap.questions.service.CategoryService;
import com.jap.questions.service.DefaultFormService;
import com.jap.questions.service.OptionsService;
import com.jap.questions.service.QuestionService;
import com.jap.questions.serviceimpl.OptionsServiceImpl;

@RestController
@RequestMapping("/iRecruit")
@CrossOrigin
public class QuestionController {
	
	@Autowired
	private QuestionService questionService;

	
	@Autowired
	private QuestionRepository questionRepository;
	
	@Autowired
	private CategoryRepository categoryRepository;
	
	
	@PostMapping("/createquestion/{categoryId}")
	public String createQuestions(@RequestBody Questions question,@PathVariable String categoryId)
	{
		return this.questionService.createQuestion(question, categoryId);
		
	}
	
	
	
	
	
	
	@DeleteMapping("/deletequestion/{questionId}")
	public String deleteQuestion(@PathVariable Long questionId)
	{
		return this.questionService.deleteQuestion(questionId);
	}
	
	
	
	@PostMapping("/addmultiple/{categoryName}")
	public String saveMultipleQuestions(@RequestBody MulltipleQuestions multipleQuestions,@PathVariable String categoryName)
	{
		Category category = this.categoryRepository.findById(categoryName).orElseThrow();
		List<Questions> questionEntity= new ArrayList<>();
		multipleQuestions.getQuestions().forEach(each ->{
			Questions questions =new Questions();
			questions.setQuestion(each.getQuestion());
			questions.setCategory(category);
			questionEntity.add(questions);
		});
		this.questionRepository.saveAll(questionEntity);
		return "Questions added Successfully";
		
	}
	
	
	
	
}
