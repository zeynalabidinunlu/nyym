package com.nyym.entites;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "content")
public class Content {
    @Id()
    @Column(name = "content_uuid")
// @GeneratedValue(strategy = GenerationType.UUID)
    private UUID contentUuid;
    
    @Column(name = "description")
    private String description;
    
    @Column(name = "share_text")
    private String shareText;
    
    @Column(name = "number_of_people")
    private Integer numberOfPeople;
    
    @Column(name = "improvements")
    private String improvements;
    
    @Column(name = "event_date")
    private LocalDateTime eventDate;
        
    @OneToMany()
    private List<Media> mediaList = new ArrayList<>();
    
}