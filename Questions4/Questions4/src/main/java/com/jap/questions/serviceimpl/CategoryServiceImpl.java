package com.jap.questions.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jap.questions.entity.Category;
import com.jap.questions.entity.DefaultForm;
import com.jap.questions.entity.Questions;
import com.jap.questions.repository.CategoryRepository;
import com.jap.questions.repository.DefaultFormRepository;
import com.jap.questions.repository.QuestionRepository;
import com.jap.questions.service.CategoryService;


@Service
public class CategoryServiceImpl implements CategoryService{
	
	@Autowired
	private CategoryRepository categoryRepository;
	
	
	@Autowired
	private QuestionRepository questionRepository;
	
	@Autowired
	private DefaultFormRepository defaultFormRepository;
	

	@Override
	public String createCategory(Category category,String dfId) {
		DefaultForm form=this.defaultFormRepository.findById(dfId).orElseThrow();
		category.setForm(form);
		String cat=category.getCategoryName();
		String catName=form.getDfId()+"_"+cat;
		category.setCategoryName(catName);
		this.categoryRepository.save(category);
		return catName+": Category created Successfully";
	}
	
	
	
	
	@Override
	public List<Category> getAllCategories() {
		return this.categoryRepository.findAll();
		
	}

	@Override
	public String deleteCategory(String categoryName) {
		Category category=this.categoryRepository.findById(categoryName).orElseThrow();
		this.categoryRepository.delete(category);
		return category.getCategoryName()+" Category deleted Successfully";
		
	}




	@Override
	public Category getCategory(String categoryName) {
		return this.categoryRepository.findById(categoryName).orElseThrow();
	}

	
	


	
	
	
	
	

}
