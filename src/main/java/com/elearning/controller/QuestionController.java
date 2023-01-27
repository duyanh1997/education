package com.elearning.controller;

import com.elearning.service.QuestionService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/app")
@RequiredArgsConstructor
public class QuestionController {
    private final QuestionService questionService;
    @GetMapping("/course/question")
    public String getQuestions(
            @RequestParam(name = "courseId") Integer courseId,
            Model model
    ){
        var questions = questionService.getQuestionsByCourseId(courseId);
        System.out.println(questions);
        model.addAttribute("questions",questions);
        return "quiz";
    }
}
