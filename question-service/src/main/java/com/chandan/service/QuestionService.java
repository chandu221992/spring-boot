package com.chandan.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chandan.dao.QuestionDao;
import com.chandan.model.Question;
import com.chandan.model.Quiz;

@Service
public class QuestionService {

	@Autowired
	private QuestionDao questionDao;

	public Question create(Question question) {
		return questionDao.save(question);
	}

	public List<Question> get() {
		return questionDao.findAll();
	
	}

	public List<Integer> generateQuiz(Quiz quiz) {
	      return questionDao.findQuestionsForQuiz(quiz.getCategory(),quiz.getNumOfQuestions());
	}

}
