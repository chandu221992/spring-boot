package com.chandan.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.chandan.model.Quiz;
import com.chandan.model.QuizDTO;
import com.chandan.service.QuizService;

@RestController
@RequestMapping("quiz")
public class QuizController {
	
	@Autowired
	private QuizService quizService;
    
	@PostMapping
	public ResponseEntity<Quiz> create(@RequestBody QuizDTO quizDTO) {
		Quiz createdQuiz = quizService.createQuiz(quizDTO);
		return new ResponseEntity<>(createdQuiz,HttpStatus.CREATED);				
	}
}
