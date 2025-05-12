package com.nyym.entites;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import jakarta.persistence.*;
import lombok.Data;
@Data
@Entity
@Table(name = "calendar_day")
public class CalendarDay {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(name = "date")
    private LocalDate date;

    @OneToMany(cascade = CascadeType.ALL)
    private List<Content> contents = new ArrayList<>();

    // Constructor, getter, setter
    public void addContent(Content content) {
        contents.add(content);
    }
}
