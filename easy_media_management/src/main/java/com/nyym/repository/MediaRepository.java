package com.nyym.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nyym.entites.Media;

public interface MediaRepository extends JpaRepository<Media, UUID>{

}
