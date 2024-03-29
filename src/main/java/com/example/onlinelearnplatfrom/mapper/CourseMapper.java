package com.example.onlinelearnplatfrom.mapper;

import com.example.onlinelearnplatfrom.dto.CourseDTO;
import com.example.onlinelearnplatfrom.entity.Course;

public class CourseMapper {
    public static CourseDTO toDto(Course course) {
        CourseDTO courseDTO = new CourseDTO();
        courseDTO.setId(course.getId());
        courseDTO.setCourseName(course.getCourseName());
        courseDTO.setCourseContent(course.getCourseContent());
        courseDTO.setCoursePrice(course.getCoursePrice());
        return courseDTO;
    }

    public static Course toEntity(CourseDTO courseDTO) {
        Course course = new Course();
        course.setId(courseDTO.getId());
        course.setCourseName(courseDTO.getCourseName());
        course.setCourseContent(courseDTO.getCourseContent());
        course.setCoursePrice(courseDTO.getCoursePrice());
        return course;
    }

    public static void update(Course course, CourseDTO courseDTO) {
        course.setId(courseDTO.getId());
        course.setCourseName(courseDTO.getCourseName());
        course.setCourseContent(courseDTO.getCourseContent());
        course.setCoursePrice(courseDTO.getCoursePrice());
    }
}
