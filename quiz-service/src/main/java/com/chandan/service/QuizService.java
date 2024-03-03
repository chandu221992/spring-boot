package com.chandan.service;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chandan.client.QuestionServiceClient;
import com.chandan.dao.QuizDao;
import com.chandan.model.Quiz;
import com.chandan.model.QuizDTO;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;

@Service
public class QuizService {

	@Autowired
	private QuizDao quizDao;
	@Autowired
	private QuestionServiceClient questionServiceClient;

	@CircuitBreaker(name = "questionservicebreaker", fallbackMethod = "createDummyQuiz")
	//@Retry(name = "questionservicebreaker", fallbackMethod = "createDummyQuiz")
	//@RateLimiter(name = "questionservicebreaker", fallbackMethod = "createDummyQuiz")
	public Quiz createQuiz(QuizDTO quizDTO) {
		List<Integer> questionIds = questionServiceClient.generateQuiz(quizDTO).getBody();
		Quiz quiz = new Quiz();
		quiz.setTitle(quizDTO.getTitle());
		quiz.setCategory(quizDTO.getCategory());
		quiz.setQuestionIds(questionIds);
		return quizDao.save(quiz);
	}

	public Quiz createDummyQuiz(Exception e) {
		Quiz quiz = new Quiz();
		quiz.setTitle("This ia a dummy quiz");
		quiz.setCategory("Dummy");
		quiz.setQuestionIds(Arrays.asList(0));
		return quiz;
	}

}
