package com.jap.questions.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jap.questions.entity.Category;

public interface CategoryRepository extends JpaRepository<Category,String>{

}
