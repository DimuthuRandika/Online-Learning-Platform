package com.example.onlinelearnplatfrom.dto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Data
public class CourseDTO {
    private Integer id;
    private String courseName;
    private String courseContent;
    private String coursePrice;
}
