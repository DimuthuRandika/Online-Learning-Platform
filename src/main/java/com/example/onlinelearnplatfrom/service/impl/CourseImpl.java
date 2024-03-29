package com.example.onlinelearnplatfrom.service.impl;

import com.example.onlinelearnplatfrom.dto.CourseDTO;
import com.example.onlinelearnplatfrom.entity.Course;
import com.example.onlinelearnplatfrom.exception.DbRecordNotFoundException;
import com.example.onlinelearnplatfrom.mapper.CourseMapper;
import com.example.onlinelearnplatfrom.repository.CourseRepository;
import com.example.onlinelearnplatfrom.service.CourseService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CourseImpl implements CourseService {

    private final CourseRepository courseRepository;

    public CourseImpl(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }

    @Override
    public List<CourseDTO> findAll() {
        List<Course> courses = courseRepository.findAll();
        return courses.stream().map(CourseMapper::toDto).collect(Collectors.toList());
    }

    @Override
    public CourseDTO findById(Integer id) {
        Course course = courseRepository.findById(id)
                .orElseThrow(() -> new DbRecordNotFoundException("Course Not Found!"));
        return CourseMapper.toDto(course);
    }

    @Override
    public CourseDTO save(CourseDTO courseDTO) {
        Course course = CourseMapper.toEntity(courseDTO);
        Course savedCourse = courseRepository.save(course);
        return CourseMapper.toDto(savedCourse);
    }

    @Override
    public CourseDTO update(Integer id, CourseDTO courseDTO) {
        Optional<Course> courseOptional = courseRepository.findById(id);
        if (courseOptional.isPresent()) {
            Course course = courseOptional.get();
            CourseMapper.update(course, courseDTO);
            Course savedCourse = courseRepository.save(course);
            return CourseMapper.toDto(savedCourse);
        } else {
            throw new DbRecordNotFoundException("Course Not Found!");
        }
    }

    @Override
    public void deleteById(Integer id) {
        courseRepository.deleteById(id);
    }
}
