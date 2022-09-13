package com.jap.questions.service;

import java.util.List;

import com.jap.questions.entity.Category;
import com.jap.questions.entity.Questions;

public interface QuestionService {
	
	String createQuestion(Questions question,String categoryName);
	List<Questions> getQuestionsOfCategory(String categoryName);
	String deleteQuestion(Long questionId);
	Questions editQuestion(Questions question,Long questionId);
	
}