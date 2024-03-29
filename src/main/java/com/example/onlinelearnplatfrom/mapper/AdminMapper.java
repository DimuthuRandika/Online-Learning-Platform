package com.example.onlinelearnplatfrom.mapper;

import com.example.onlinelearnplatfrom.dto.AdminDTO;
import com.example.onlinelearnplatfrom.entity.Admin;

public class AdminMapper {
    public static AdminDTO toDto(Admin admin) {
        AdminDTO adminDTO = new AdminDTO();
        adminDTO.setId(admin.getId());
        adminDTO.setEmail(admin.getEmail());
        adminDTO.setPassword(admin.getPassword());
        adminDTO.setAdminName(admin.getAdminName());
        adminDTO.setMobileNumberPrimary(admin.getMobileNumberPrimary());
        return adminDTO;
    }

    public static Admin toEntity(AdminDTO adminDTO) {
        Admin admin = new Admin();
        admin.setId(adminDTO.getId());
        admin.setEmail(adminDTO.getEmail());
        admin.setPassword(adminDTO.getPassword());
        admin.setAdminName(adminDTO.getAdminName());
        admin.setMobileNumberPrimary(adminDTO.getMobileNumberPrimary());
        return admin;
    }

    public static void update(Admin admin, AdminDTO adminDTO) {
        admin.setId(adminDTO.getId());
        admin.setEmail(adminDTO.getEmail());
        admin.setPassword(adminDTO.getPassword());
        admin.setAdminName(adminDTO.getAdminName());
        admin.setMobileNumberPrimary(adminDTO.getMobileNumberPrimary());
    }
}
