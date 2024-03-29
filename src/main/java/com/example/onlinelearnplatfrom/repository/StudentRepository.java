package com.example.onlinelearnplatfrom.repository;

import com.example.onlinelearnplatfrom.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository <Student ,Integer> {
}
