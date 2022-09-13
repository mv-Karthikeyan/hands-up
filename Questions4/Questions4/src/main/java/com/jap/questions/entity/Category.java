package com.jap.questions.entity;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
public class Category {
	
//	
//	@GeneratedValue(strategy=GenerationType.AUTO)
//	private int categoryId;
//	
//	
	@Id
	private String categoryName;

	
	@OneToMany(mappedBy="category",cascade=CascadeType.ALL,fetch=FetchType.LAZY)
	private List<Questions> questions=new ArrayList<>();
	
	
	
	@ManyToOne
	@JsonIgnore
	@JoinColumn(name="form_name")
	private DefaultForm form;
	

	public String getCategoryName() {
		return categoryName;
	}


	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}


	public List<Questions> getQuestions() {
		return questions;
	}


	public void setQuestions(List<Questions> questions) {
		this.questions = questions;
	}


	public DefaultForm getForm() {
		return form;
	}


	public void setForm(DefaultForm form) {
		this.form = form;
	}




	
	
	
	
	
}
