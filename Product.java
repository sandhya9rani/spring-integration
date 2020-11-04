package com.ust.springintegration.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Product implements Comparable<Product>
{

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	
	public int id;
	public String productName;
	public Double price;
	
	
	public Product()
	{
		super();
	}

	public Product(int id, String productName, Double price)
	{
		super();
		this.id = id;
		this.productName = productName;
		this.price = price;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		result = prime * result + ((price == null) ? 0 : price.hashCode());
		result = prime * result + ((productName == null) ? 0 : productName.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Product other = (Product) obj;
		if (id != other.id)
			return false;
		if (price == null) {
			if (other.price != null)
				return false;
		} else if (!price.equals(other.price))
			return false;
		if (productName == null) {
			if (other.productName != null)
				return false;
		} else if (!productName.equals(other.productName))
			return false;
		return true;
	}

	@Override
	public String toString() 
	{
		return "Product [id=" + id + ", productName=" + productName + ", price=" + price + "]";
	}

	@Override
	public int compareTo(Product o) 
	{
		if (this.id > o.id) 
		{
			return 1;
		} else if (this.id < o.id)
		{
			return -1;
		} else 
		{
			return 0;
		}
	}
	
}
