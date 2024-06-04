package com.epicode.BookingManagement.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EventDTO {
    private Long id;

    @NotBlank(message = "Title is mandatory")
    private String title;

    @NotBlank(message = "Description is mandatory")
    private String description;

    @NotNull(message = "Date and time are mandatory")
    private LocalDateTime dateTime;

    @NotBlank(message = "Location is mandatory")
    private String location;

    @Min(value = 1, message = "There must be at least one available seat")
    private int availableSeats;
}
