package com.example.onlinelearnplatfrom.dto;

import lombok.*;

import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Data
public class StudentDTO {
    private Integer id;
    private String email;
    private String firstName;
    private String lastName;
    private String mobileNumberPrimary;
    private Set<Long> courseId;
}
