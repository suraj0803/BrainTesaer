package com.kuldeep.BrainTeaser.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.kuldeep.BrainTeaser.entity.Question;
import com.kuldeep.BrainTeaser.payloads.ApiResponse;

public interface QuestionService {

	public ResponseEntity<ApiResponse> addQuestion(Long quizId, Question question)throws Exception;

	public List<Question> getAllQuestion(Long quizId) throws Exception;

	public Question updateQuestion(Long quizId,Question question) throws Exception;

	public void deleteQuestion(Long quizId, Long questionId) throws Exception;

}
