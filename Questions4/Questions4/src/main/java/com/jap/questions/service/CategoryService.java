package com.jap.questions.service;
import java.util.List;

import com.jap.questions.entity.Category;

public interface CategoryService {
	
	String createCategory(Category category,String dfId);
	List<Category> getAllCategories();
	String deleteCategory(String categoryName);
	Category getCategory(String categoryName);

}
