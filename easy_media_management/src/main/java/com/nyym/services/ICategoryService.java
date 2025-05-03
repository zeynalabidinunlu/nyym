package com.nyym.services;

import java.util.List;

import com.nyym.entites.Category;

public interface ICategoryService {

	public Category saveCategory(Category category);
	
	public List<Category> getAllCategories();
}
