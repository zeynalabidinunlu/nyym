package com.nyym.controller.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nyym.controller.ICategoryController;
import com.nyym.entites.Category;
import com.nyym.services.ICategoryService;

@RequestMapping("/rest/api/category")
@RestController()
public class CategoryControllerImpl implements ICategoryController {

	@Autowired
	private ICategoryService categoryService;

	@PostMapping(path = "/saveCategory")
	@Override
	public Category saveCategory(@RequestBody Category category) {

		return categoryService.saveCategory(category);
	}

	
	@GetMapping(path = "/getAllCategories")
	@Override
	public List<Category> getAllCategories() {
		return categoryService.getAllCategories();
	}

}
