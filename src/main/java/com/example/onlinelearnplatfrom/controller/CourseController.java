package com.example.onlinelearnplatfrom.controller;

import com.example.onlinelearnplatfrom.dto.CourseDTO;
import com.example.onlinelearnplatfrom.service.CourseService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/courses", produces = MediaType.APPLICATION_JSON_VALUE)
public class CourseController {

    private final CourseService courseService;

    public CourseController(CourseService courseService) {
        this.courseService = courseService;
    }

    @GetMapping
    public List<CourseDTO> getAll() {
        return courseService.findAll();
    }

    @GetMapping(value = "/{id}")
    public CourseDTO getById(
            @NotNull(message = "Course ID is required")
            @PathVariable("id") Integer id) {
        return courseService.findById(id);
    }

    @PostMapping
    public CourseDTO save(@Valid @RequestBody CourseDTO courseDTO) {
        return courseService.save(courseDTO);
    }

    @PutMapping(value = "/{id}")
    public CourseDTO update(
            @NotNull(message = "Course ID is required")
            @PathVariable("id") Integer id,
            @Valid @RequestBody CourseDTO courseDTO) {
        return courseService.update(id, courseDTO);
    }

    @DeleteMapping(value = "/{id}")
    public void deleteById(
            @NotNull(message = "Course ID is required")
            @PathVariable("id") Integer id) {
        courseService.deleteById(id);
    }
}