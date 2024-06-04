package com.epicode.BookingManagement.mapper;

import com.epicode.BookingManagement.dto.RoleDTO;
import com.epicode.BookingManagement.entity.Role;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface RoleMapper {
    RoleDTO toDto(Role role);
    Role toRole(RoleDTO roleDTO);
}
