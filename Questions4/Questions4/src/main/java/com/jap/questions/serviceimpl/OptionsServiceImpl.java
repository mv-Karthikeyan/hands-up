package com.jap.questions.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jap.questions.entity.Options;
import com.jap.questions.entity.Questions;
import com.jap.questions.repository.OptionsRepository;
import com.jap.questions.repository.QuestionRepository;
import com.jap.questions.service.OptionsService;

@Service
public class OptionsServiceImpl implements OptionsService{
	
	@Autowired
	private OptionsRepository optionsRepository;
	
	@Autowired
	private QuestionRepository questionRepository;

	@Override
	public String createOption(Options option, Long questionId) {
		Questions question = this.questionRepository.findById(questionId).orElseThrow();
		option.setQuestionName(question);
		this.optionsRepository.save(option);
		return "Option added successfully to :"+question.getQuestion();
	}

	@Override
	public Options updateOption(Options option, Long optionId) {
		Options opt=this.optionsRepository.findById(optionId).orElseThrow();
		opt.setOptionName(option.getOptionName());
		this.optionsRepository.save(opt);
		return opt;
	}

	@Override
	public String deleteOption(Long optionId) {
		Options opt=this.optionsRepository.findById(optionId).orElseThrow();
		this.optionsRepository.deleteById(optionId);
		return "Deleted Successfully";
	}

	@Override
	public List<Options> getAllOptionsOfQuestions(Long questionId) {
		Questions ques=this.questionRepository.findById(questionId).orElseThrow();
		return ques.getOptions();
	}

	

}
