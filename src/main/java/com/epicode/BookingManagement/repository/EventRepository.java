package com.epicode.BookingManagement.repository;

import com.epicode.BookingManagement.entity.Event;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EventRepository extends JpaRepository<Event, Long> {
}
