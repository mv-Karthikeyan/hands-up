package com.jap.questions.service;

import java.util.List;

import com.jap.questions.entity.Section;

public interface SectionService {
	
	Section createSection(Section section);
	Section getSection(Long secId);
	List<Section> getAllSections();

}
