package com.chandan.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.chandan.model.Question;
import com.chandan.model.Quiz;
import com.chandan.service.QuestionService;

@RestController
@RequestMapping("question")
public class QuestionController {
	
	@Autowired
	private QuestionService questionService;

	@PostMapping
	public ResponseEntity<Question> create(@RequestBody Question question) {
		Question createdQuestion=questionService.create(question);		
		return new ResponseEntity<>(createdQuestion,HttpStatus.CREATED);
	}
	
	@GetMapping
	public ResponseEntity<List<Question>> get() {
		List<Question> questions=questionService.get();
		return new ResponseEntity<>(questions,HttpStatus.OK);
	}
	
	@PostMapping("generate")
	public ResponseEntity<List<Integer>> generateQuiz(@RequestBody Quiz quiz) {
		List<Integer> questions=questionService.generateQuiz(quiz);
		return new ResponseEntity<>(questions,HttpStatus.OK);
	}

}
