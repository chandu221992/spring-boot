package com.chandan.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.chandan.model.Question;

public interface QuestionDao extends JpaRepository<Question, Integer> {

	@Query(value = "select id from question where category=:category order by random() limit :numOfQuestions", nativeQuery = true)
	List<Integer> findQuestionsForQuiz(String category, int numOfQuestions);

}
