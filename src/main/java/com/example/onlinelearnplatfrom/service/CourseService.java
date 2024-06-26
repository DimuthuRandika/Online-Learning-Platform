package com.example.onlinelearnplatfrom.service;

import com.example.onlinelearnplatfrom.dto.CourseDTO;

import java.util.List;

public interface CourseService {
    List<CourseDTO> findAll();
    CourseDTO findById(Integer id);
    CourseDTO save(CourseDTO courseDTO);

    CourseDTO update(Integer id, CourseDTO courseDTO);
    void deleteById(Integer id);
}
