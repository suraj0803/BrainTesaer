package com.kuldeep.BrainTeaser.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.kuldeep.BrainTeaser.entity.Quiz;
import com.kuldeep.BrainTeaser.payloads.ApiResponse;

public interface QuizService {

	public ResponseEntity<ApiResponse> createQuiz(Quiz quiz);

	public List<Quiz> getAllQuiz();

	public Quiz getQuizById(Long quizId)throws Exception;

	public Quiz updateQuiz(Quiz quiz);

	public void deleteQuiz(Long quizId);

}
