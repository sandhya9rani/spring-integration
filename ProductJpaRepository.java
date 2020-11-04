package com.ust.springintegration.services;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ust.springintegration.entities.Product;

public interface ProductJpaRepository extends JpaRepository<Product,Integer>
{
	public Product findByProductName(String productName);
}

