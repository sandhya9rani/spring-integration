package com.ust.springintegration.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ust.springintegration.entities.Product;

@Service
public class ProductService
{
	@Autowired
	ProductJpaRepository productRepository;
	
	public List<Product> fetchAllProducts() 
	{
		
		return productRepository.findAll();
	}
	
public boolean findByProductName(String productName) {
		
	Product p = productRepository.findByProductName(productName);
		if(p==null)
		{
			return false;
		}
		return true;
	}
public void addProduct(Product input) 
{	
	productRepository.save(input);
}
	
public void deleteProduct(int id)
{
	productRepository.deleteById(id);	
}

}
