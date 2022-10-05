package com.kuldeep.BrainTeaser.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.kuldeep.BrainTeaser.entity.Question;
import com.kuldeep.BrainTeaser.entity.Quiz;
import com.kuldeep.BrainTeaser.payloads.ApiResponse;
import com.kuldeep.BrainTeaser.repository.QuestionRepository;
import com.kuldeep.BrainTeaser.repository.QuizRepository;
@Service
public class QuestionServiceImpl implements QuestionService{
	
	@Autowired
	private QuestionRepository questionRepository;
	
	@Autowired
	private QuizRepository quizRepository;
	
	@Override
	public ResponseEntity<ApiResponse> addQuestion(Long quizId, Question question) throws Exception{
		Quiz quiz = quizRepository.getOne(quizId);
		if(quiz==null) {
			throw new Exception("Quiz "+quizId +"not found");
		}
		
		List<Question> ques = questionRepository.findAll();
		for(Question other : ques) {
			if(other.equals(ques)) {
				return new ResponseEntity<ApiResponse>(new ApiResponse("Question is Already there",true),HttpStatus.OK);
			}
		}
		questionRepository.save(question);
		return new ResponseEntity<ApiResponse>(new ApiResponse("Question added Successfully!!!",false),HttpStatus.CREATED);
	}

	@Override
	public List<Question> getAllQuestion(Long quizId) throws Exception{
		Quiz quiz = quizRepository.getById(quizId);
		if(quiz==null) {
			throw new Exception("Quiz "+quizId +"not found");
		}
		List<Question> ques = questionRepository.findAll();
		return ques;
	}

	@Override
	public Question updateQuestion(Long quizId,Question question) throws Exception{
		Quiz quiz = quizRepository.getById(quizId);
		if(quiz==null) {
			throw new Exception("Quiz "+quizId +"not found");
		}
		questionRepository.save(question);
		return question;
	}

	@Override
	public void deleteQuestion(Long quizId, Long questionId) throws Exception{
		Quiz quiz = quizRepository.getById(quizId);
		if(quiz==null) {
			throw new Exception("Quiz "+quizId +"not found");
		}
		questionRepository.deleteById(questionId);
	}

}
