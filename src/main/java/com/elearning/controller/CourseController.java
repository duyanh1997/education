package com.elearning.controller;

import com.elearning.service.CourseService;
import jakarta.persistence.criteria.CriteriaBuilder;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/app")
@RequiredArgsConstructor
public class CourseController {
    private final CourseService courseService;
    @GetMapping("/course")
    public String courseHome(
            @RequestParam(name = "pageNumber",defaultValue = "0")Integer pageNumber,
            @RequestParam(name = "pageSize",defaultValue = "9")Integer pageSize,
            Model model
    ){
        var page = courseService.getCourses(pageNumber,pageSize);
        var course = page.getContent();
        model.addAttribute("page",page);
        model.addAttribute("url","/app/course");
        model.addAttribute("course",course);
        return "home";

    }
}
