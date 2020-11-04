package com.ust.springintegration.services;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ust.springintegration.entities.Category;

public interface CategoryJpaRepository extends JpaRepository<Category,Integer>
{
	public Category findByName(String productName);
}


