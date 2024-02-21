package com.chandan.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.chandan.model.Quiz;

public interface QuizDao extends JpaRepository<Quiz, Integer>{

}
