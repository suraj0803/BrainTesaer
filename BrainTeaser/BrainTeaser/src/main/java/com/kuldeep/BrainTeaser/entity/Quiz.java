package com.kuldeep.BrainTeaser.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Quiz {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long quizId;
	private String quizTitle;
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private List<Question> questionList;
	
	public Quiz() {
		// TODO Auto-generated constructor stub
	}

	public Long getQuizId() {
		return quizId;
	}

	public void setQuizId(Long quizId) {
		this.quizId = quizId;
	}

	public String getQuizTitle() {
		return quizTitle;
	}

	public void setQuizTitle(String quizTitle) {
		this.quizTitle = quizTitle;
	}

	public List<Question> getQuestionList() {
		return questionList;
	}

	public void setQuestionList(List<Question> questionList) {
		this.questionList = questionList;
	}

	@Override
	public String toString() {
		return "Quiz [quizId=" + quizId + ", quizTitle=" + quizTitle + "]";
	}

	public Quiz(Long quizId, String quizTitle, List<Question> questionList) {
		super();
		this.quizId = quizId;
		this.quizTitle = quizTitle;
		this.questionList = questionList;
	}
	
	
	
}
