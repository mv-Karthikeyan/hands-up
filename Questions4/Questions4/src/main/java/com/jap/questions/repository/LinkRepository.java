package com.jap.questions.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jap.questions.entity.Link;


public interface LinkRepository extends JpaRepository<Link,Long>{

}