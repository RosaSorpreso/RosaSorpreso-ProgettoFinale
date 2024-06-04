package com.epicode.BookingManagement.service;


import com.epicode.BookingManagement.dto.EventDTO;
import com.epicode.BookingManagement.entity.Event;
import com.epicode.BookingManagement.mapper.EventMapper;
import com.epicode.BookingManagement.repository.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EventService {
    @Autowired
    private EventRepository eventRepository;

    @Autowired
    private EventMapper eventMapper;

    public EventDTO saveEvent(EventDTO eventDTO) {
        Event event = eventMapper.toEntity(eventDTO);
        return eventMapper.toDTO(eventRepository.save(event));
    }

    public void deleteEvent(Long eventId) {
        eventRepository.deleteById(eventId);
    }

    public List<EventDTO> getAllEvents() {
        return eventRepository.findAll().stream()
                .map(eventMapper::toDTO)
                .collect(Collectors.toList());
    }

    public Event getEvent(Long eventId) {
        return eventRepository.findById(eventId).orElseThrow(() -> new RuntimeException("Event not found"));
    }

}
