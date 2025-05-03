package com.nyym.controller;

import java.util.List;

import com.nyym.entites.Category;

public interface ICategoryController {

	public Category saveCategory(Category category);
	
	public List<Category> getAllCategories();
}
