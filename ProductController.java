package com.ust.springintegration;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ust.springintegration.entities.Product;
import com.ust.springintegration.services.ProductService;


@RestController
@RequestMapping("/api/products")
public class ProductController 
{
	@Autowired
	ProductService productService;
	
	@GetMapping("/hello")
	public String hello()
	{
		return "Welcome to springboot";
	}

	@GetMapping("/")
	public Product fetchProduct()
	{
		Product input = new Product(20,"ABC",60000.00);
		return input;
	}
	
	@PostMapping("/products")
	public ResponseEntity<Object> addProduct(@RequestBody Product product)
	{
		if(productService.findByProductName(product.productName))
		{
			return new ResponseEntity<>(HttpStatus.CONFLICT);
		}
		
		productService.addProduct(product);
		return new ResponseEntity<>(HttpStatus.CREATED);
	}
	
	@GetMapping("/products")
	public List<Product> fetchAllProducts()
	{
		return productService.fetchAllProducts();
	}
	
	@RequestMapping(path="/{id}",method=RequestMethod.DELETE)
	public ResponseEntity<String> deleteProduct(@PathVariable("id") int id)
	{
		ResponseEntity<String> re = null;
		try {

			productService.deleteProduct(id);
			re = ResponseEntity.ok().body("employee has been deleted successfully");
		}
		catch(EmptyResultDataAccessException e)
		{
			re = new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return re;
	}
}
