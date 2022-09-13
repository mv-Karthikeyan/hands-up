package com.jap.questions.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jap.questions.entity.Section;
import com.jap.questions.service.SectionService;

@RestController
@RequestMapping("/iRecruit")
@CrossOrigin
public class SectionController {
	
	@Autowired
	private SectionService sectionService;
	
	
	@PostMapping("/createsection")
	public Section createSection(@RequestBody Section section)
	{
		return this.sectionService.createSection(section);
	}
	
	
	@GetMapping("/getsection/{sectionId}")
	public Section getSection(@PathVariable Long sectionId)
	{
		return this.sectionService.getSection(sectionId);
	}
	
	
	@GetMapping("/getallsections")
	public List<Section> getSection()
	{
		return this.sectionService.getAllSections();
	}
	
}
