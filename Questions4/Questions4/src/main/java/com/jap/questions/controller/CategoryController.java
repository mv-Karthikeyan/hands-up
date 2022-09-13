package com.jap.questions.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jap.questions.entity.Category;
import com.jap.questions.entity.Questions;
import com.jap.questions.service.CategoryService;
import com.jap.questions.service.QuestionService;


@RestController
@RequestMapping("/iRecruit")
@CrossOrigin
public class CategoryController {
	
	@Autowired
	private CategoryService categoryService;
	
	@Autowired
	private QuestionService questionService;
	
	
	
	@PostMapping("/createcategory/{dfId}")
	public String createCategory(@RequestBody Category category,@PathVariable String dfId)
	{
		return this.categoryService.createCategory(category,dfId);
	}
	
	
	@GetMapping("/getall/{categoryId}")
	public List<Questions> getAllQuestionsByCategory(@PathVariable String categoryId)
	{
		return this.questionService.getQuestionsOfCategory(categoryId);
		
		
	}
	
	@GetMapping("/getallcategories")
	public List<Category> getAllCategories()
	{
		return this.categoryService.getAllCategories();
	}
	
	@DeleteMapping("/deletecategory/{categoryId}")
	public String deleteCategory(@PathVariable String categoryId)
	{
		return this.categoryService.deleteCategory(categoryId);
	}
	
	@GetMapping("/getcategory/{categoryName}")
	public Category getCategoryById(@PathVariable String categoryName)
	{
		return this.categoryService.getCategory(categoryName);
	}
	

}
