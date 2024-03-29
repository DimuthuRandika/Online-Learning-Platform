package com.example.onlinelearnplatfrom.repository;

import com.example.onlinelearnplatfrom.entity.Admin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdminRepository extends JpaRepository<Admin, Integer> {

}
