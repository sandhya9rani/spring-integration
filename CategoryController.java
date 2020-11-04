package com.ust.springintegration;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import com.ust.springintegration.entities.Category;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;


import com.ust.springintegration.services.CategoryService;


@RestController
@RequestMapping("/api/categories")
public class CategoryController 
{
	@Autowired
	CategoryService categoryService;
	
	@GetMapping("/hello")
	public String hello()
	{
		return "Welcome to springboot";
	}
	
	@GetMapping("/")
	public Category fetchCategory()
	{
		Category input = new Category(20,"ABC",1.5,"1.0");
		return input;
	}

	@PostMapping("/categories")
	public ResponseEntity<Object> addCategory(@RequestBody Category category)
	{
		if(categoryService.findByName(category.name))
		{
			return new ResponseEntity<>(HttpStatus.CONFLICT);
		}
		
		categoryService.addCategory(category);
		return new ResponseEntity<>(HttpStatus.CREATED);
	}
	@GetMapping("/categories")
	public List<Category> fetchAllCategories()
	{
		return categoryService.fetchAllCategories();
	}
	
	@RequestMapping(path="/{id}",method=RequestMethod.DELETE)
	public ResponseEntity<String> deleteCategory(@PathVariable("id") int id)
	{
		ResponseEntity<String> re = null;
		try {

			categoryService.deleteCategory(id);
			re = ResponseEntity.ok().body("employee has been deleted successfully");
		}
		catch(EmptyResultDataAccessException e)
		{
			re = new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return re;
	}
}
