package com.kuldeep.BrainTeaser.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.kuldeep.BrainTeaser.entity.Question;
import com.kuldeep.BrainTeaser.entity.Quiz;
import com.kuldeep.BrainTeaser.payloads.ApiResponse;
import com.kuldeep.BrainTeaser.service.QuestionService;
import com.kuldeep.BrainTeaser.service.QuizService;

@RestController
public class QuizController {
	
	@Autowired
	private QuizService quizService;
	@Autowired
	private QuestionService questionService;
	
	@PostMapping("/quiz/create")
	public ResponseEntity<ApiResponse> createQuiz(@RequestBody Quiz quiz){
		return this.quizService.createQuiz(quiz);
	}
	
	@GetMapping("/quiz/getAllQuiz")
	public List<Quiz> getAllQuiz(){
		return this.quizService.getAllQuiz();
	}
	
	@GetMapping("/quiz/getQuizById/{quizId}")
	public Quiz getQuizById(@PathVariable Long quizId) throws Exception{
		return this.quizService.getQuizById(quizId);
	}
	
	@PutMapping("/quiz/updateQuiz")
	public ResponseEntity<ApiResponse> updateQuiz(@RequestBody Quiz quiz){
		 try{
			 this.quizService.updateQuiz(quiz);
			 return new ResponseEntity<ApiResponse>(new ApiResponse("Quiz updated successfully!!!",true),HttpStatus.OK);
		 }
		 catch(Exception e) {
			 return new ResponseEntity<ApiResponse>(new ApiResponse("Quiz has not been updated!!!",false),HttpStatus.INTERNAL_SERVER_ERROR);
		 }
	}
	
	@DeleteMapping("/quiz/deleteQuiz/{quizId}")
	public ResponseEntity<ApiResponse> deleteQuiz(@PathVariable Long quizId){
		try {
			this.quizService.deleteQuiz(quizId);
			return new ResponseEntity<ApiResponse>(new ApiResponse("Quiz is deleted successfully!!!",true),HttpStatus.OK);
		}
		catch(Exception e) {
			return new ResponseEntity<ApiResponse>(new ApiResponse("Invalid Id of Quiz",false),HttpStatus.NOT_FOUND);
		}
	}
	
	@PostMapping("quiz/{quizId}/addQuestion")
	public ResponseEntity<ApiResponse> addQuestion(@PathVariable Long quizId,@RequestBody Question question){
		return this.questionService.addQuestion(quizId,question);
	}
	
	@GetMapping("/quiz/{quizId}/getAllQuestion")
	public List<Question> getAllQuestion(@PathVariable Long quizId) throws Exception{
		return this.questionService.getAllQuestion(quizId);
	}
	
	@PutMapping("/quiz/{quizId}/updateQuestion")
	public ResponseEntity<ApiResponse> updateQuestion(@PathVariable Long quizId,@RequestBody Question question){
		try{
			this.questionService.updateQuestion(quizId,question);
			return new ResponseEntity<ApiResponse>(new ApiResponse("Question is updated successfully!!!",true),HttpStatus.OK);
		}
		catch(Exception e) {
			return new ResponseEntity<ApiResponse>(new ApiResponse("Question has not been updated!!!",false),HttpStatus.NOT_ACCEPTABLE);
		}
	}
	
	@DeleteMapping("/quiz/{quizId}/deleteQuestion/{questionId}")
	public ResponseEntity<ApiResponse> deleteQuestion(@PathVariable Long quizId, @PathVariable Long questionId){
		try {
			this.questionService.deleteQuestion(quizId,questionId);
			return new ResponseEntity<ApiResponse>(new ApiResponse("Question is deleted Successfully",true),HttpStatus.OK);
		}
		catch(Exception e) {
			return new ResponseEntity<ApiResponse>(new ApiResponse("Question has not been deleted!!!",false),HttpStatus.NOT_FOUND);
		}
	}
}
