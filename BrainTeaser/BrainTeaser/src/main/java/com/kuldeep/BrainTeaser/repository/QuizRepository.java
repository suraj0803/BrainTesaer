package com.kuldeep.BrainTeaser.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.kuldeep.BrainTeaser.entity.Quiz;
@Repository
public interface QuizRepository extends JpaRepository<Quiz,Long>{

}
