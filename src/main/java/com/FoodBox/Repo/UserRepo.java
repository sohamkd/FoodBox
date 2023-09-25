package com.FoodBox.Repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.FoodBox.Model.User;

public interface UserRepo extends JpaRepository<User, Long> {

	
	Optional<User> findUserByEmail(String email);

}
