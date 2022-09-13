package com.jap.questions.serviceimpl;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jap.questions.entity.DefaultForm;
import com.jap.questions.entity.Section;
import com.jap.questions.repository.CategoryRepository;
import com.jap.questions.repository.DefaultFormRepository;
import com.jap.questions.repository.OptionsRepository;
import com.jap.questions.repository.QuestionRepository;
import com.jap.questions.repository.SectionRepository;
import com.jap.questions.service.DefaultFormService;


@Service
public class DefaultFormServiceImpl implements DefaultFormService{
	
	@Autowired
	private DefaultFormRepository deafultFormRepository;
	
	@Autowired
	private SectionRepository sectionRepository;
	
	@Autowired
	private CategoryRepository categoryRepository;
	
	private QuestionRepository questionsRepository;
	
	private OptionsRepository optionsRepositroy;

	@Override
	public String createDefaultForm(DefaultForm defaultForm,Long sectionId) throws Exception {
		Section sec=this.sectionRepository.findById(sectionId).orElseThrow();
			defaultForm.setFormCreationDate(sentTimeMethod());
			defaultForm.setSectioMapped(sec);
			this.deafultFormRepository.save(defaultForm);
			return "Created";
		
	}

	@Override
	public List<DefaultForm> getAllDefaultForms() {
		return this.deafultFormRepository.findAll();
	}

	@Override
	public String deleteDefaultForm(String dfId) {
		DefaultForm defaultForm=this.deafultFormRepository.findById(dfId).orElseThrow();
		this.deafultFormRepository.delete(defaultForm);
		return "Deleted Successfully";
	}

	@Override
	public String editDefaultForm(DefaultForm defaultForm, String dfId) {
		DefaultForm data=this.deafultFormRepository.findById(dfId).orElseThrow();
		data.setDfName(defaultForm.getDfName());
		this.deafultFormRepository.save(data);
		return "Updated";
	}

	private java.util.Date sentTimeMethod() {
		Calendar calendar =Calendar.getInstance();
		calendar.setTimeInMillis(new Date().getTime());
		return new Date(calendar.getTime().getTime());
		
	}
	

	@Override
	public DefaultForm copyForm(String dfId) {
		DefaultForm fetchedForm = this.deafultFormRepository.findById(dfId).orElseThrow();
		DefaultForm newForm = new DefaultForm();
		newForm.setDfName(fetchedForm.getDfName());
		newForm.setFormCreationDate(sentTimeMethod());
		this.deafultFormRepository.save(newForm);
		return newForm;
	}
	
}
