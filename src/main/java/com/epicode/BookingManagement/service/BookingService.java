package com.epicode.BookingManagement.service;

import com.epicode.BookingManagement.dto.BookingDTO;
import com.epicode.BookingManagement.entity.Booking;
import com.epicode.BookingManagement.entity.Event;
import com.epicode.BookingManagement.entity.User;
import com.epicode.BookingManagement.mapper.BookingMapper;
import com.epicode.BookingManagement.repository.BookingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BookingService {
    @Autowired
    private BookingRepository bookingRepository;

    @Autowired
    private BookingMapper bookingMapper;

    public BookingDTO bookEvent(User user, Event event) {
        Booking booking = new Booking();
        booking.setUser(user);
        booking.setEvent(event);
        return bookingMapper.toDTO(bookingRepository.save(booking));
    }

    public List<BookingDTO> getBookingsByUser(User user) {
        return bookingRepository.findByUser(user).stream()
                .map(bookingMapper::toDTO)
                .collect(Collectors.toList());
    }

    public List<BookingDTO> getBookingsByEvent(Event event) {
        return bookingRepository.findByEvent(event).stream()
                .map(bookingMapper::toDTO)
                .collect(Collectors.toList());
    }

    public void cancelBooking(Long bookingId) {
        bookingRepository.deleteById(bookingId);
    }
}
