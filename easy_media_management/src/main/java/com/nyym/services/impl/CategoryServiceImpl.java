package com.nyym.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nyym.entites.Category;
import com.nyym.repository.CategoryRepository;
import com.nyym.services.ICategoryService;

@Service
public class CategoryServiceImpl implements ICategoryService {

	@Autowired
	private CategoryRepository categoryRepository;
	
	
	@Override
	public Category saveCategory(Category category) {
		return categoryRepository.save(category);
			
	}

	@Override
	public List<Category> getAllCategories() {
	
		return categoryRepository.findAll();
		
	}

}
