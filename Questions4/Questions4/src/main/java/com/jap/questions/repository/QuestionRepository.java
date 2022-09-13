package com.jap.questions.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jap.questions.entity.Category;
import com.jap.questions.entity.Questions;

public interface QuestionRepository extends JpaRepository<Questions,Long>{
	List<Questions> findByCategory(Category category);

}
