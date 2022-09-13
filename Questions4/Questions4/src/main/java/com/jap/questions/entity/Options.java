package com.jap.questions.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Options {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long optionId;
	
	private String optionName;
	

	@ManyToOne
	@JsonIgnore
	@JoinColumn(name="question_id")
	private Questions questionName;
	
	
	
	public long getOptionId() {
		return optionId;
	}

	public void setOptionId(long optionId) {
		this.optionId = optionId;
	}

	public String getOptionName() {
		return optionName;
	}

	public void setOptionName(String optionName) {
		this.optionName = optionName;
	}

	public Questions getQuestionName() {
		return questionName;
	}

	public void setQuestionName(Questions questionName) {
		this.questionName = questionName;
	}

	
	
}
