package com.nyym.observer;

import com.nyym.entites.CalendarDay;
import com.nyym.entites.Content;
import com.nyym.repository.CalendarDayRepository;
import java.time.LocalDate;

public class CalendarObserver implements ContentObserver {

    private final CalendarDayRepository calendarDayRepository;

    public CalendarObserver(CalendarDayRepository calendarDayRepository) {
        this.calendarDayRepository = calendarDayRepository;
    }

    @Override
    public void onContentCreated(Content content) {
        LocalDate date = content.getEventDate().toLocalDate();
        CalendarDay calendarDay = calendarDayRepository.findByDate(date).orElse(new CalendarDay());

        calendarDay.setDate(date);
        calendarDay.addContent(content);
        calendarDayRepository.save(calendarDay);
    }
}
