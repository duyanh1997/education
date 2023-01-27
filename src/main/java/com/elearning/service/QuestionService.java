package com.elearning.service;

import com.elearning.dto.QuestionDto;
import com.elearning.repository.QuestionRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class QuestionService {
    private final QuestionRepository questionRepository;
    private final ModelMapper modelMapper;

    public List<QuestionDto> getQuestionsByCourseId(Integer courseId) {
        var listQuestions = questionRepository.findByCourse_CourseId(courseId);
        var listQuestionsDto = new ArrayList<QuestionDto>();
        for(var q : listQuestions){
            listQuestionsDto.add(modelMapper.map(q,QuestionDto.class));
        }
        return listQuestionsDto;
    }
}
