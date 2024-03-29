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
@Table(name = "STUDENT")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Integer id;

    @Column(name = "EMAIL", length = 45 , nullable = false)
    private String email;

    @Column(name = "PASSWORD", length = 512, nullable = false)
    private String password;

    @Column(name = "FIRST_NAME", length = 20, nullable = false)
    private String firstName;

    @Column(name = "LAST_NAME", length = 20)
    private String lastName;

    @Column(name = "MOBILE_NUMBER_PRIMARY", length = 12, unique = true, nullable = false)
    private String mobileNumberPrimary;

    @ManyToMany(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    @JoinTable(name = "STUDENT_HAS_COURSE", joinColumns = @JoinColumn(name = "STUDENT_ID"), inverseJoinColumns = @JoinColumn(name = "COURSE_ID"))
    private Set<Course> courses;
}
