package com.FoodBox.Services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.FoodBox.Model.Product;


import com.FoodBox.Repo.ProductRepo;

@Service

public class ProductService {

	@Autowired
	ProductRepo productRepo;

	public List<Product> getAllProduct() {
		return productRepo.findAll();
	}
	public void addProduct(Product product) {
		productRepo.save(product);
	}
	public void removeProductById(long id) {
		productRepo.deleteById(id);
	}
	public Optional<Product> getProductById(long id){
		return productRepo.findById(id);		
	}
	public List<Product> getAllProductsByCategoryId(int id){
		return productRepo.findAllByCategory_Id(id);
	}
	
	 public List<Product> listAll(String name) {
	        if (name!= null) {
	            return productRepo.search(name);
	        }
	        return productRepo.findAll();
	    }
	

}
