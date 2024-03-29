package com.example.onlinelearnplatfrom.service.impl;

import com.example.onlinelearnplatfrom.dto.StudentDTO;
import com.example.onlinelearnplatfrom.entity.Student;
import com.example.onlinelearnplatfrom.exception.DbRecordNotFoundException;
import com.example.onlinelearnplatfrom.mapper.StudentMapper;
import com.example.onlinelearnplatfrom.repository.StudentRepository;
import com.example.onlinelearnplatfrom.service.StudentService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class StudentImpl implements StudentService {

    private final StudentRepository studentRepository;

    public StudentImpl(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }


    @Override
    public List<StudentDTO> findAll() {
        List<Student> students = studentRepository.findAll();
        return students.stream().map(StudentMapper::toDto).collect(Collectors.toList());
    }

    @Override
    public StudentDTO findById(Integer id) {
        Student student = studentRepository.findById(id)
                .orElseThrow(() -> new DbRecordNotFoundException("Student Not Found!"));
        return StudentMapper.toDto(student);
    }

    @Override
    public StudentDTO save(StudentDTO studentDTO) {
        if (studentDTO.getEmail() == null || studentDTO.getEmail().trim().equals(""))
            throw new DbRecordNotFoundException("Student email is required!");

        Student student = StudentMapper.toEntity(studentDTO);
        Student savedStudent = studentRepository.save(student);
        return StudentMapper.toDto(savedStudent);
    }

    @Override
    public StudentDTO update(Integer id, StudentDTO studentDTO) {
        if (studentDTO.getEmail() == null || studentDTO.getEmail().trim().equals(""))
            throw new DbRecordNotFoundException("Student email is required!");

        Student student = studentRepository.findById(id)
                .orElseThrow(() -> new DbRecordNotFoundException("Student Not Found!"));
        StudentMapper.update(student, studentDTO);
        Student savedStudent = studentRepository.save(student);
        return StudentMapper.toDto(savedStudent);
    }

    @Override
    public void deleteById(Integer id) {
        studentRepository.deleteById(id);
    }
}
