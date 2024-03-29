package com.example.onlinelearnplatfrom.service;

import com.example.onlinelearnplatfrom.dto.StudentDTO;

import java.util.List;

public interface StudentService {


    List<StudentDTO> findAll();

    StudentDTO findById(Integer id);

    StudentDTO save(StudentDTO studentDTO);

    StudentDTO update(Integer id, StudentDTO studentDTO);

    void deleteById(Integer id);
}
