package com.elearning.service;

import com.elearning.dto.CourseDto;
import com.elearning.repository.CourseRepository;
import jakarta.persistence.criteria.CriteriaBuilder;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class CourseService {
    private final ModelMapper modelMapper;
    private final CourseRepository courseRepository;
    public Page<CourseDto> getCourses(Integer pageNumber,Integer pageSize){
        Pageable pageable = PageRequest.of(pageNumber,pageSize);
        var page = courseRepository.findAll(pageable);
        return page.map(course
                -> modelMapper.map(course, CourseDto.class));
    }

}
