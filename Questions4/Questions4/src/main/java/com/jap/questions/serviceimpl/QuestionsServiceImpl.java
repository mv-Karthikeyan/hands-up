package com.jap.questions.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jap.questions.entity.Category;
import com.jap.questions.entity.Questions;
import com.jap.questions.repository.CategoryRepository;
import com.jap.questions.repository.QuestionRepository;
import com.jap.questions.service.QuestionService;

@Service
public class QuestionsServiceImpl implements QuestionService{
	
	@Autowired
	private QuestionRepository questionRepository;
	
	@Autowired
	private CategoryRepository categoryRepository;

	@Override
	public String createQuestion(Questions question, String categoryName) {
		Category category = this.categoryRepository.findById(categoryName).orElseThrow();
		question.setCategory(category);
		this.questionRepository.save(question);
		return "Question Created";

	}

	@Override
	public List<Questions> getQuestionsOfCategory(String categoryName) {
		Category category = this.categoryRepository.findById(categoryName).orElseThrow();
		List<Questions> questions=this.questionRepository.findByCategory(category);
		return questions;
	}

	@Override
	public String deleteQuestion(Long questionId) {
		Questions question=this.questionRepository.findById(questionId).orElseThrow();
		this.questionRepository.delete(question);
		return "Question deleted successfully";
	}

	@Override
	public Questions editQuestion(Questions question, Long questionId) {
		Questions ques =this.questionRepository.findById(questionId).orElseThrow();
		ques.setQuestion(question.getQuestion());
		this.questionRepository.save(ques);
		return ques;
	}
	
	




	

	

}
