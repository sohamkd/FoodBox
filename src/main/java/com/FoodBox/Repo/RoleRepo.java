package com.FoodBox.Repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.FoodBox.Model.Role;


public interface RoleRepo  extends JpaRepository<Role, Integer>{
	
}
