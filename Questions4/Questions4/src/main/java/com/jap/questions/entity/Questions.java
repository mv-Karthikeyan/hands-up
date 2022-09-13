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
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import org.hibernate.annotations.GenericGenerator;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.Parameter;

@Entity
public class Questions {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long questionId;
	private String question;
	
	
	@ManyToOne
	@JsonIgnore
	@JoinColumn(name="category_name")
	private Category category;
	
	
	
	@OneToMany(mappedBy="questionName",cascade=CascadeType.ALL,fetch=FetchType.LAZY)
	private List<Options> options =new ArrayList<>();
	

	public Long getQuestionId() {
		return questionId;
	}


	public void setQuestionId(Long questionId) {
		this.questionId = questionId;
	}


	public String getQuestion() {
		return question;
	}


	public void setQuestion(String question) {
		this.question = question;
	}


	public Category getCategory() {
		return category;
	}


	public void setCategory(Category category) {
		this.category = category;
	}


	public List<Options> getOptions() {
		return options;
	}


	public void setOptions(List<Options> options) {
		this.options = options;
	}
	
	
	
	
	
	
	
	
	
	
	
	

}
