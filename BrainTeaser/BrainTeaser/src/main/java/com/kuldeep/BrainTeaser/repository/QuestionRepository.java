package com.kuldeep.BrainTeaser.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.kuldeep.BrainTeaser.entity.Question;
@Repository
public interface QuestionRepository extends JpaRepository<Question,Long>{

}
