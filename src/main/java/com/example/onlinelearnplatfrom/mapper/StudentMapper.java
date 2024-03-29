package com.example.onlinelearnplatfrom.mapper;

import com.example.onlinelearnplatfrom.dto.StudentDTO;
import com.example.onlinelearnplatfrom.entity.Student;

public class StudentMapper {
    public static StudentDTO toDto(Student student) {
        StudentDTO studentDTO = new StudentDTO();
        studentDTO.setId(student.getId());
        studentDTO.setEmail(student.getEmail());
        studentDTO.setFirstName(student.getFirstName());
        studentDTO.setLastName(student.getLastName());
        studentDTO.setPassword(student.getPassword());
        studentDTO.setMobileNumberPrimary(student.getMobileNumberPrimary());
        // Map courses here if needed
        return studentDTO;
    }

    public static Student toEntity(StudentDTO studentDTO) {
        Student student = new Student();
        student.setId(studentDTO.getId());
        student.setEmail(studentDTO.getEmail());
        student.setFirstName(studentDTO.getFirstName());
        student.setLastName(studentDTO.getLastName());
        student.setPassword(studentDTO.getPassword());
        student.setMobileNumberPrimary(studentDTO.getMobileNumberPrimary());
        // Map courses here if needed
        return student;
    }

    public static void update(Student student, StudentDTO studentDTO) {
        student.setId(studentDTO.getId());
        student.setEmail(studentDTO.getEmail());
        student.setFirstName(studentDTO.getFirstName());
        student.setLastName(studentDTO.getLastName());
        student.setPassword(studentDTO.getPassword());
        student.setMobileNumberPrimary(studentDTO.getMobileNumberPrimary());
        // Update courses here if needed
    }
}
