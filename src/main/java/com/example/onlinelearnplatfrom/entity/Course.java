package com.example.onlinelearnplatfrom.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "COURSE")
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Integer id;

    @Column(name = "COURSE_NAME", length = 20, nullable = false)
    private String courseName;

    @Column(name = "COURSE_CONTENT", length = 300)
    private String courseContent;

    @Column(name = "COURSE_PRICE", length = 20, unique = true, nullable = false)
    private String coursePrice;

    @ManyToMany(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    @JoinTable(name = "COURSE_HAS_STUDENT", joinColumns = @JoinColumn(name = "COURSE_ID"), inverseJoinColumns = @JoinColumn(name = "STUDENT_ID"))
    private Set<Student> students;
}
