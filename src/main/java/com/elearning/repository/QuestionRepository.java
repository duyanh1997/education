package com.elearning.repository;

import com.elearning.model.Question;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface QuestionRepository extends JpaRepository<Question, Integer> {
    List<Question> findByCourse_CourseId(Integer courseId);
}
