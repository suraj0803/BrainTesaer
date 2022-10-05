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
public class Question {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long questionId;
	private String questionText;
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private List<Option> option;
	private Integer displayTime;
	private String correctAnswer;
	
	public Question() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Question [questionId=" + questionId + ", questionText=" + questionText + ", displayTime=" + displayTime
				+ ", correctAnswer=" + correctAnswer + "]";
	}

	public Long getQuestionId() {
		return questionId;
	}

	public void setQuestionId(Long questionId) {
		this.questionId = questionId;
	}

	public String getQuestionText() {
		return questionText;
	}

	public void setQuestionText(String questionText) {
		this.questionText = questionText;
	}

	public List<Option> getOption() {
		return option;
	}

	public void setOption(List<Option> option) {
		this.option = option;
	}

	public Integer getDisplayTime() {
		return displayTime;
	}

	public void setDisplayTime(Integer displayTime) {
		this.displayTime = displayTime;
	}

	public String getCorrectAnswer() {
		return correctAnswer;
	}

	public void setCorrectAnswer(String correctAnswer) {
		this.correctAnswer = correctAnswer;
	}

	public Question(Long questionId, String questionText, List<Option> option, Integer displayTime,
			String correctAnswer) {
		super();
		this.questionId = questionId;
		this.questionText = questionText;
		this.option = option;
		this.displayTime = displayTime;
		this.correctAnswer = correctAnswer;
	}
	
	
}
