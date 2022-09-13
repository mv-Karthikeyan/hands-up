package com.jap.questions.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jap.questions.entity.Section;
import com.jap.questions.repository.SectionRepository;
import com.jap.questions.service.SectionService;

@Service
public class SectionServiceImpl implements SectionService{
	
	@Autowired
	private SectionRepository sectionRepository;

	@Override
	public Section createSection(Section section) {
		Section sectionObj=this.sectionRepository.save(section);
		return sectionObj;
	}

	@Override
	public Section getSection(Long secId) {
		Section secdata=this.sectionRepository.findById(secId).orElseThrow();
		return secdata;
	}

	@Override
	public List<Section> getAllSections() {
		return this.sectionRepository.findAll();
	}

}
