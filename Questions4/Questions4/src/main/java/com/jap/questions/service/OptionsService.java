package com.jap.questions.service;

import java.util.List;

import com.jap.questions.entity.Options;

public interface OptionsService {
	String createOption(Options option,Long questionId);
	Options updateOption(Options option,Long optionId);
	String deleteOption(Long optionId);
	List<Options> getAllOptionsOfQuestions(Long questionId);
	
	

}
