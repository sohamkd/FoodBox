package com.FoodBox.Repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.FoodBox.Model.Product;


public interface ProductRepo extends JpaRepository<Product, Long> {
	
	List<Product> findAllByCategory_Id(int id) ;

	  @Query("SELECT p FROM Product p WHERE p.name LIKE %?1%"
	            + " OR p.description LIKE %?1%"
	            + " OR p.weight LIKE %?1%"
	            + " OR CONCAT(p.price, '') LIKE %?1%")
	    public List<Product> search(String name);


	}

