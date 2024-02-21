package com.chandan.client;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.chandan.model.QuizDTO;

@FeignClient("QUESTION-SERVICE")
public interface QuestionServiceClient {

	@PostMapping("question/generate")
	ResponseEntity<List<Integer>> generateQuiz(@RequestBody QuizDTO quizDTO);

}
