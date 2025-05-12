package com.nyym.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.nyym.entites.CalendarDay;

import java.time.LocalDate;
import java.util.Optional;
import java.util.UUID;

public interface CalendarDayRepository extends JpaRepository<CalendarDay, UUID> {
    Optional<CalendarDay> findByDate(LocalDate date);
}
