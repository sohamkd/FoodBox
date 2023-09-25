package com.FoodBox.Repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.FoodBox.Model.Category;

public interface CategoryRepo extends JpaRepository<Category, Integer> {

}
