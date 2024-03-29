package com.example.onlinelearnplatfrom.controller;

import com.example.onlinelearnplatfrom.dto.AdminDTO;
import com.example.onlinelearnplatfrom.service.AdminService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/admin", produces = MediaType.APPLICATION_JSON_VALUE)
public class AdminController {

    private final AdminService adminService;

    public AdminController(AdminService adminService) {
        this.adminService = adminService;
    }

    @GetMapping
    public List<AdminDTO> getAll() {
        return adminService.findAll();
    }

    @GetMapping(value = "/{id}")
    public AdminDTO getById(
            @NotNull(message = "Admin ID is required")
            @PathVariable("id") Integer id) {
        return adminService.findById(id);
    }

    @PostMapping
    public AdminDTO save(@Valid @RequestBody AdminDTO adminDTO) {
        return adminService.save(adminDTO);
    }

    @PutMapping(value = "/{id}")
    public AdminDTO update(
            @NotNull(message = "Admin ID is required")
            @PathVariable("id") Integer id,
            @Valid @RequestBody AdminDTO adminDTO) {
        return adminService.update(id, adminDTO);
    }

    @DeleteMapping(value = "/{id}")
    public void deleteById(
            @NotNull(message = "Admin ID is required")
            @PathVariable("id") Integer id) {
        adminService.deleteById(id);
    }
}