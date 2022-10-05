package com.kuldeep.BrainTeaser.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.kuldeep.BrainTeaser.entity.Option;

@Repository
public interface OptionRepository extends JpaRepository<Option,Long>{

}
