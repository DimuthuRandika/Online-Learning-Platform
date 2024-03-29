package com.example.onlinelearnplatfrom.service;

import com.example.onlinelearnplatfrom.dto.AdminDTO;
import com.example.onlinelearnplatfrom.dto.StudentDTO;

import java.util.List;

public interface AdminService {


    List<AdminDTO> findAll();

    AdminDTO findById(Integer id);

    AdminDTO save(AdminDTO studentDTO);

    AdminDTO update(Integer id, AdminDTO adminDTO);

    void deleteById(Integer id);
}
