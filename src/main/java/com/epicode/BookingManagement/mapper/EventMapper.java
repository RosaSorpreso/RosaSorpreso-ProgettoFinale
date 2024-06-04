package com.epicode.BookingManagement.mapper;

import com.epicode.BookingManagement.dto.EventDTO;
import com.epicode.BookingManagement.entity.Event;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface EventMapper {
    EventDTO toDTO(Event event);
    Event toEntity(EventDTO eventDTO);
}
