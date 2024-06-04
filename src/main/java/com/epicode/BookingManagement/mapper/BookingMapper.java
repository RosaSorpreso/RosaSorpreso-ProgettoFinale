package com.epicode.BookingManagement.mapper;

import com.epicode.BookingManagement.dto.BookingDTO;
import com.epicode.BookingManagement.entity.Booking;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring")
public interface BookingMapper {
    @Mappings({
            @Mapping(source = "user.id", target = "userId" ),
            @Mapping(source = "event.id", target = "eventId")
    })
    BookingDTO toDTO(Booking booking);

    @Mappings({
            @Mapping(source = "userId", target = "user.id"),
            @Mapping(source = "eventId", target = "event.id")
    })
    Booking toEntity(BookingDTO bookingDTO);

}
