package com.jap.questions.service;

import java.util.List;

import com.jap.questions.entity.DefaultForm;

public interface DefaultFormService {
	
	String createDefaultForm(DefaultForm defaultForm,Long sectionId) throws Exception;
	List<DefaultForm> getAllDefaultForms();
	String deleteDefaultForm(String dfId);
	String editDefaultForm(DefaultForm defaultForm,String dfId);

	DefaultForm copyForm(String dfId);
}
