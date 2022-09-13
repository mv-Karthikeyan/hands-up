package com.jap.questions.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jap.questions.entity.DefaultForm;

public interface DefaultFormRepository extends JpaRepository<DefaultForm,String>{

}
