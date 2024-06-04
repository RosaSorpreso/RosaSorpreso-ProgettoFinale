package com.epicode.BookingManagement.repository;

import com.epicode.BookingManagement.entity.Booking;
import com.epicode.BookingManagement.entity.Event;
import com.epicode.BookingManagement.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BookingRepository extends JpaRepository<Booking, Long> {
    List<Booking> findByUser(User user);
    List<Booking> findByEvent(Event event);
}
