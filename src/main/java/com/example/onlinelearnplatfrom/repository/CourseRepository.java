package com.example.onlinelearnplatfrom.repository;

import com.example.onlinelearnplatfrom.entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseRepository extends JpaRepository<Course, Integer> {
}
