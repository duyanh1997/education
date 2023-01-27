package com.elearning.repository;

import com.elearning.model.Course;
import com.elearning.model.Question;
import com.github.javafaker.Faker;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CourseRepositoryTest {
    @Autowired
    CourseRepository courseRepository;
    @Autowired
    QuestionRepository questionRepository;
    List<String> name = List.of("Java", "Python", "Kotlin", "Js");

    @Test
    void addCourses() {
        Random random = new Random();
        for (int i = 0; i < 10; i++) {
            int randomIndex = random.nextInt(name.size());
            Course course = new Course();
            course.setCourseName(name.get(randomIndex));
            course.setCategory(randomIndex + 1);
            course.setCourseDescription(name.get(randomIndex) + " is a programing language");
            courseRepository.save(course);
        }
    }

    @Test
    @Transactional
    @Rollback(value = false)
    void addQuestion() {
        Faker faker = new Faker();
        var list = courseRepository.findAll();
        Random random = new Random();
        for (var c : list) {
            for (int i = 0; i < 4; i++) {
                Question question = Question.builder()
                        .content(faker.lorem().characters(15))
                        .selection1(faker.lorem().characters(15))
                        .selection2(faker.lorem().characters(15))
                        .selection3(faker.lorem().characters(15))
                        .selection4(faker.lorem().characters(15))
                        .answer(random.nextInt(4) + 1)
                        .course(c)
                        .build();
                c.getQuestions().add(question);
            }
        }


    }
}