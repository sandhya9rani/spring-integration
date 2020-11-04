package com.ust.springintegration.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ust.springintegration.entities.Category;


@Service
public class CategoryService 
{
	@Autowired
	CategoryJpaRepository categoryRepository;
	
	public List<Category> fetchAllCategories() 
	{
		
		return categoryRepository.findAll();
	}
	
public boolean findByName(String name) {
		
	Category c = categoryRepository.findByName(name);
		if(c==null)
		{
			return false;
		}
		return true;
	}
public void addCategory(Category input) 
{	
	categoryRepository.save(input);
}
	
public void deleteCategory(int id)
{
	categoryRepository.deleteById(id);	
}
}
