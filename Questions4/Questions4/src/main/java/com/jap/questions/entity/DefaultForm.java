package com.jap.questions.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.FetchType;


import javax.persistence.CascadeType;

@Entity
public class DefaultForm {
	
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="demo_sql")
	@GenericGenerator(name="demo_sql",strategy="com.jap.questions.entity.StringPrefixedSequenceGenerator",parameters= {
			@Parameter(name=StringPrefixedSequenceGenerator.INCREMENT_PARAM,value="1"),
			@Parameter(name=StringPrefixedSequenceGenerator.VALUE_PREFIX_PARAMETER,value="iR_"),
			@Parameter(name=StringPrefixedSequenceGenerator.NUMBER_FORMAT_PARAMETER,value="%03d")
	})
	@Id
	private String dfId;
	private String dfName;
	private Date formCreationDate;
	
	
	@OneToMany(mappedBy="form",cascade=CascadeType.ALL,fetch=FetchType.LAZY)
	private List<Category> categories=new ArrayList<>();
	
	@ManyToOne
	@JsonIgnore
	private Section sectioMapped;


	public String getDfId() {
		return dfId;
	}


	public void setDfId(String dfId) {
		this.dfId = dfId;
	}


	public String getDfName() {
		return dfName;
	}


	public void setDfName(String dfName) {
		this.dfName = dfName;
	}


	public List<Category> getCategories() {
		return categories;
	}


	public void setCategories(List<Category> categories) {
		this.categories = categories;
	}


	

	public Date getFormCreationDate() {
		return formCreationDate;
	}


	public void setFormCreationDate(Date formCreationDate) {
		this.formCreationDate = formCreationDate;
	}


	public Section getSectioMapped() {
		return sectioMapped;
	}


	public void setSectioMapped(Section sectioMapped) {
		this.sectioMapped = sectioMapped;
	}
	
	
	

}
