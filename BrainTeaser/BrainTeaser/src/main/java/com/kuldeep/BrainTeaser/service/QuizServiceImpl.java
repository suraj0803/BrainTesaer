package com.kuldeep.BrainTeaser.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.kuldeep.BrainTeaser.entity.Quiz;
import com.kuldeep.BrainTeaser.payloads.ApiResponse;
import com.kuldeep.BrainTeaser.repository.QuizRepository;
@Service
public class QuizServiceImpl implements QuizService{
	
	@Autowired
	private QuizRepository quizRepository;

	@Override
	public ResponseEntity<ApiResponse> createQuiz(Quiz quiz) {
		List<Quiz> quizzes = quizRepository.findAll();
		for(Quiz others : quizzes) {
			if(others.equals(quizzes)) {
				return new ResponseEntity<ApiResponse>(new ApiResponse("Quiz is already there!!",true),HttpStatus.OK);
			}
		}
		quizRepository.save(quiz);
		return new ResponseEntity<ApiResponse>(new ApiResponse("Quiz is created successfully!!!",true),HttpStatus.CREATED);
	}

	@Override
	public List<Quiz> getAllQuiz() {
		List<Quiz> quizzes = quizRepository.findAll();
		return quizzes;
	}

	@Override
	public Quiz getQuizById(Long quizId) throws Exception{
		Quiz quiz = quizRepository.getById(quizId);
		if(quiz==null) {
			throw new Exception("Quiz "+quizId +"not found");
		}
		return quiz;
	}

	@Override
	public Quiz updateQuiz(Quiz quiz) {
		this.quizRepository.save(quiz);
		return quiz;
	}

	@Override
	public void deleteQuiz(Long quizId) {
		Quiz entity = quizRepository.getOne(quizId);
		quizRepository.delete(entity);
	}

}
