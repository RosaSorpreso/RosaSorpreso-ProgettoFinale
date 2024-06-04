package com.epicode.BookingManagement.service;

import com.epicode.BookingManagement.dto.RoleDTO;
import com.epicode.BookingManagement.entity.Role;
import com.epicode.BookingManagement.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class RoleService {

    @Autowired
    private RoleRepository roleRepository;

    public RoleDTO saveRole(RoleDTO roleDTO) {
        // Converti il RoleDTO in Role
        Role role = new Role();
        role.setName(roleDTO.getName());

        // Salva il ruolo nel repository
        role = roleRepository.save(role);

        // Converti il Role salvato in RoleDTO
        RoleDTO savedRoleDTO = new RoleDTO();
        savedRoleDTO.setId(role.getId());
        savedRoleDTO.setName(role.getName());

        return savedRoleDTO;
    }

    public RoleDTO findByName(String name) {
        Role role = roleRepository.findByName(name);
        if (role == null) {
            return null; // O lancia un'eccezione se preferisci
        }

        // Converti il Role trovato in RoleDTO
        RoleDTO roleDTO = new RoleDTO();
        roleDTO.setId(role.getId());
        roleDTO.setName(role.getName());

        return roleDTO;
    }

    public List<RoleDTO> getAllRoles() {
        return roleRepository.findAll().stream()
                .map(role -> {
                    RoleDTO roleDTO = new RoleDTO();
                    roleDTO.setId(role.getId());
                    roleDTO.setName(role.getName());
                    return roleDTO;
                })
                .collect(Collectors.toList());
    }

    public void deleteRole(Long id) {
        roleRepository.deleteById(id);
    }
}
