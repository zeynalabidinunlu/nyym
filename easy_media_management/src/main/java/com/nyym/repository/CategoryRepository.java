package com.nyym.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nyym.entites.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category, UUID>{

}
