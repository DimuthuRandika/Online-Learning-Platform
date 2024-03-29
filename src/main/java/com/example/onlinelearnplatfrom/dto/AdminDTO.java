package com.example.onlinelearnplatfrom.dto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Data
public class AdminDTO {
    private Integer id;
    private String email;
    private String password;
    private String adminName;
    private String mobileNumberPrimary;
}
