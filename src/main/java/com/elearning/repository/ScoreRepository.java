package com.elearning.repository;

import com.elearning.model.Score;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ScoreRepository extends JpaRepository<Score,Integer> {
}
