package com.example.onlinelearnplatfrom.controller;

import com.example.onlinelearnplatfrom.dto.StudentDTO;
import com.example.onlinelearnplatfrom.service.StudentService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/students", produces = MediaType.APPLICATION_JSON_VALUE)
public class StudentController {

    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping
    public List<StudentDTO> getAll() {
        return studentService.findAll();
    }

    @GetMapping(value = "/{id}")
    public StudentDTO getById(
            @NotNull(message = "Student ID is required")
            @PathVariable("id") Integer id) {
        return studentService.findById(id);
    }

    @PostMapping
    public StudentDTO save(@Valid @RequestBody StudentDTO studentDTO) {
        return studentService.save(studentDTO);
    }

    @PutMapping(value = "/{id}")
    public StudentDTO update(
            @NotNull(message = "Student ID is required")
            @PathVariable("id") Integer id,
            @Valid @RequestBody StudentDTO studentDTO) {
        return studentService.update(id, studentDTO);
    }

    @DeleteMapping(value = "/{id}")
    public void deleteById(
            @NotNull(message = "Student ID is required")
            @PathVariable("id") Integer id) {
        studentService.deleteById(id);
    }
}