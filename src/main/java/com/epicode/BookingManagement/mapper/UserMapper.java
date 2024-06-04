package com.epicode.BookingManagement.mapper;

import com.epicode.BookingManagement.dto.UserDTO;
import com.epicode.BookingManagement.entity.User;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = {RoleMapper.class})
public interface UserMapper {

    UserDTO toDTO(User user);

    User toEntity(UserDTO userDTO);
}
