package com.example.onlinelearnplatfrom.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "ADMIN")
public class Admin {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Integer id;

    @Column(name = "ADMIN_NAME", length = 20, nullable = false)
    private String AdminName;

    @Column(name = "EMAIL", length = 45 , nullable = false)
    private String email;

    @Column(name = "PASSWORD", length = 512, nullable = false)
    private String password;

    @Column(name = "MOBILE_NUMBER_PRIMARY", length = 12, unique = true, nullable = false)
    private String mobileNumberPrimary;

}
