package com.chandan.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chandan.client.QuestionServiceClient;
import com.chandan.dao.QuizDao;
import com.chandan.model.Quiz;
import com.chandan.model.QuizDTO;

@Service
public class QuizService {

	@Autowired
	private QuizDao quizDao;
	@Autowired
	private QuestionServiceClient questionServiceClient;

	public Quiz createQuiz(QuizDTO quizDTO) {
		List<Integer> questionIds = questionServiceClient.generateQuiz(quizDTO).getBody();
		System.out.println(questionIds);
		Quiz quiz = new Quiz();
		quiz.setTitle(quizDTO.getTitle());
		quiz.setCategory(quizDTO.getCategory());
		quiz.setQuestionIds(questionIds);
		return quizDao.save(quiz);
	}

}
