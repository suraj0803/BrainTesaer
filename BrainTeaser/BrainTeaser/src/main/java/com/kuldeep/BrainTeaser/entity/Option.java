package com.kuldeep.BrainTeaser.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Option {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long optionId;
	private String optionValue;
	
	public Option() {
		// TODO Auto-generated constructor stub
	}

	public Long getOptionId() {
		return optionId;
	}

	public void setOptionId(Long optionId) {
		this.optionId = optionId;
	}

	public String getOptionValue() {
		return optionValue;
	}

	public void setOptionValue(String optionValue) {
		this.optionValue = optionValue;
	}

	@Override
	public String toString() {
		return "Option [optionId=" + optionId + ", optionValue=" + optionValue + "]";
	}

	public Option(Long optionId, String optionValue) {
		super();
		this.optionId = optionId;
		this.optionValue = optionValue;
	}
	
	
}
