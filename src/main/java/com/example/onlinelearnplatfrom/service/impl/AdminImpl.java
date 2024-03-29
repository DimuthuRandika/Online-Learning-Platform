package com.example.onlinelearnplatfrom.service.impl;

import com.example.onlinelearnplatfrom.dto.AdminDTO;
import com.example.onlinelearnplatfrom.entity.Admin;
import com.example.onlinelearnplatfrom.exception.DbRecordNotFoundException;
import com.example.onlinelearnplatfrom.mapper.AdminMapper;
import com.example.onlinelearnplatfrom.repository.AdminRepository;
import com.example.onlinelearnplatfrom.service.AdminService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AdminImpl implements AdminService {

    private final AdminRepository adminRepository;

    public AdminImpl(AdminRepository adminRepository) {
        this.adminRepository = adminRepository;
    }


    @Override
    public List<AdminDTO> findAll() {
        List<Admin> admins = adminRepository.findAll();
        return admins.stream().map(AdminMapper::toDto).collect(Collectors.toList());
    }

    @Override
    public AdminDTO findById(Integer id) {
        Admin admin = adminRepository.findById(id)
                .orElseThrow(() -> new DbRecordNotFoundException("Admin Not Found!"));
        return AdminMapper.toDto(admin);
    }

    @Override
    public AdminDTO save(AdminDTO adminDTO) {
        if (adminDTO.getAdminName() == null || adminDTO.getAdminName().trim().equals(""))
            throw new DbRecordNotFoundException("Admin Name is required!");
        if (adminDTO.getPassword() == null || adminDTO.getPassword().trim().equals(""))
            throw new DbRecordNotFoundException("Admin Password is required!");
        if (adminDTO.getMobileNumberPrimary() == null || adminDTO.getMobileNumberPrimary().trim().equals(""))
            throw new DbRecordNotFoundException("Admin Number is required!");

        if (adminDTO.getEmail() == null || adminDTO.getEmail().trim().equals(""))
            throw new DbRecordNotFoundException("Admin email is required!");

        Admin admin = AdminMapper.toEntity(adminDTO);
        Admin savedAdmin = adminRepository.save(admin);
        return AdminMapper.toDto(savedAdmin);
    }

    @Override
    public AdminDTO update(Integer id, AdminDTO adminDTO) {

        if (adminDTO.getAdminName() == null || adminDTO.getAdminName().trim().equals(""))
            throw new DbRecordNotFoundException("Admin Name is required!");
        if (adminDTO.getPassword() == null || adminDTO.getPassword().trim().equals(""))
            throw new DbRecordNotFoundException("Admin Password is required!");
        if (adminDTO.getMobileNumberPrimary() == null || adminDTO.getMobileNumberPrimary().trim().equals(""))
            throw new DbRecordNotFoundException("Admin Number is required!");
        if (adminDTO.getEmail() == null || adminDTO.getEmail().trim().equals(""))
            throw new DbRecordNotFoundException("Admin email is required!");


        Admin admin = adminRepository.findById(id)
                .orElseThrow(() -> new DbRecordNotFoundException("Admin Not Found!"));
        AdminMapper.update(admin, adminDTO);
        Admin savedAdmin = adminRepository.save(admin);
        return AdminMapper.toDto(savedAdmin);
    }

    @Override
    public void deleteById(Integer id) {

        Admin admin = adminRepository.findById(id)
                .orElseThrow(() -> new DbRecordNotFoundException("Admin Not Found!"));
        adminRepository.deleteById(admin.getId());
    }
}
