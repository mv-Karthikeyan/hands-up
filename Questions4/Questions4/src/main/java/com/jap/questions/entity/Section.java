package com.jap.questions.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Section {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long sectionId;
	
	private String sectionName;
	
	
	@OneToMany(cascade=CascadeType.ALL,fetch=FetchType.EAGER,mappedBy="sectioMapped")
	private List<DefaultForm> formName=new ArrayList<>();

	public long getSectionId() {
		return sectionId;
	}

	public void setSectionId(long sectionId) {
		this.sectionId = sectionId;
	}

	public String getSectionName() {
		return sectionName;
	}

	public void setSectionName(String sectionName) {
		this.sectionName = sectionName;
	}

	public List<DefaultForm> getFormName() {
		return formName;
	}

	public void setFormName(List<DefaultForm> formName) {
		this.formName = formName;
	}
	
	

}
