package com.nyym.controller.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nyym.entites.CalendarDay;
import com.nyym.repository.CalendarDayRepository;

@RestController
@RequestMapping("/api")
public class CalendarRestController {

    @Autowired
    private CalendarDayRepository calendarDayRepository;

    @GetMapping("/calendar-days")
    public List<CalendarDay> getAllCalendarDays() {
        return calendarDayRepository.findAll();
    }
}